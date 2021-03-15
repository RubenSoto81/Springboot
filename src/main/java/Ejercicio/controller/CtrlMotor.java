package Ejercicio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import Ejercicio.entity.Motor;
import Ejercicio.service.MotorService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CtrlMotor {

  @Autowired
  private MotorService motorService;
  private final String ENVIO_POST_FORM = "/motor/crear";

  @GetMapping("/motor/crear")
  public String nuevoMotor(Model model) {
    model.addAttribute("titulo", "Crear un motor");
    model.addAttribute("saludo", "Creando un motor");
    model.addAttribute("subsaludo", "Introduce los datos que se piden a continuación");
    model.addAttribute("postForm", ENVIO_POST_FORM);
    Motor motor = new Motor();
    model.addAttribute("motor", motor);
    return "motor/create";
  }

  @PostMapping("/motor/crear")
  public String creadoMotor(Model model,
          @Valid @ModelAttribute("motor") Motor motor,
          BindingResult bindingResult) {

    if (bindingResult.hasErrors()) {
      System.out.println("Errores en la validación: " + bindingResult.getAllErrors());
      model.addAttribute("titulo", "Crear un motor. Revise datos");
      model.addAttribute("saludo", "Se creará un motor válido. Revise los datos ingresados");
      model.addAttribute("subsaludo", "Introduzca los datos que se piden a continuación. Revise todos los avisos de error");
      model.addAttribute("postForm", ENVIO_POST_FORM);
      return "motor/create";
    }

    model.addAttribute("titulo", "Motor creado");
    model.addAttribute("saludo", "Motor creado");
    model.addAttribute("subsaludo", "Verifique los datos");
    motorService.guardaMotor(motor);
    return "motor/detail";
  }

  @RequestMapping("/motor/listar")
  public String readMotor(Model model) {
    model.addAttribute("tituloWeb", "Ver motores");
    model.addAttribute("titulo", "Ver motores");
    model.addAttribute("subtitulo", "Mostrando listado de motores de la BBDD");
    model.addAttribute("motores", motorService.getMotores());
    return "motor/read";
  }

  @GetMapping("/motor/update/{id}")
  public String updateMotor(@PathVariable("id") Long id, Model model) {
    String ruta;
    ruta = "/motor/update/" + id;
    model.addAttribute("tituloWeb", "Actualizar motor");
    model.addAttribute("titulo", "Actualizar motor");
    model.addAttribute("subtitulo", "Actualizando motor en la BBDD");
    model.addAttribute("postForm", ruta);
    model.addAttribute("motor", motorService.getByID(id));
    model.addAttribute("actualizando", true);
    return "motor/create";
  }

  @PostMapping("/motor/update/{id}")
  public String saveUpdateMotor(@PathVariable("id") Long id,
          @Valid @ModelAttribute("motor") Motor motor,
          BindingResult bindingResult,
          Model model) {
    String ruta;
    ruta = "/motor/update/" + id;
    if (bindingResult.hasErrors()) {
      System.out.println("Errores en la validación: " + bindingResult.getAllErrors());
      model.addAttribute("error", true);
      model.addAttribute("tituloWeb", "Actualizar motor");
      model.addAttribute("titulo", "Actualizar motor");
      model.addAttribute("subtitulo", "Actualizando motor en la BBDD");
      model.addAttribute("motor", motor);
      model.addAttribute("actualizando", true);
      model.addAttribute("postForm", ruta);
      return "motor/create";
    }

    model.addAttribute("tituloWeb", "Actualizar motor");
    model.addAttribute("titulo", "Actualizar motor");
    model.addAttribute("subtitulo", "Actualizado motor en la BBDD");
    System.out.println("Updating motor: " + motor);
    motorService.guardaMotor(motor);
    model.addAttribute("motores", motorService.getMotores());
    model.addAttribute("actualizado", true);
    return "motor/read";
  }

  @RequestMapping("/motor/delete/{id}")
  public String deleteMotor(@PathVariable("id") Long id, Model model) {
    motorService.borraMotor(id);
    model.addAttribute("tituloWeb", "Elimina motor");
    model.addAttribute("titulo", "Elimina motor");
    model.addAttribute("subtitulo", "Eliminado motor concreto de la BBDD");
    model.addAttribute("motores", motorService.getMotores());
    model.addAttribute("eliminado", true);
    return "motor/read";
  }

  @RequestMapping("/motor/ver/{id}")
  public String show(@PathVariable("id") Long id, Model model) {
    model.addAttribute("tituloWeb", "Ver motor");
    model.addAttribute("titulo", "Ver motor");
    model.addAttribute("subtitulo", "Mostrando motor concreto de la BBDD");
    motorService.getByIDsoloMostrar(id).ifPresent(o -> model.addAttribute("motor", o));    
    return "motor/detail";
  }

}
