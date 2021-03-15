package Ejercicio.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import Ejercicio.model.InformesCommand;
import Ejercicio.service.InformeService;

@Controller
public class CtrlInforme {

  /* @Autowired
  private InformesRepository informeRepositorio;*/
  @Autowired
  private InformeService informeService;

  @RequestMapping("/informes/listar")
  public String read(Model model) {
    model.addAttribute("tituloWeb", "Ver informes");
    model.addAttribute("titulo", "Ver informes");
    model.addAttribute("subtitulo", "Mostrando listado de informes de la BBDD");
//    model.addAttribute("informes", informeRepositorio.findAll());
    model.addAttribute("informes", informeService.getInformes());

    return "informes/read";
  }

  @RequestMapping("/informes/ver/{id}")
  public String show(@PathVariable("id") Long id, Model model) {
    model.addAttribute("tituloWeb", "Ver informe");
    model.addAttribute("titulo", "Ver informe");
    model.addAttribute("subtitulo", "Mostrando informe concreto de la BBDD");

    //  informeRepositorio.findById(id).ifPresent(o -> model.addAttribute("informe", o));
    informeService.getByID(id).ifPresent(o -> model.addAttribute("informe", o));

    return "informes/detail";
  }

  @RequestMapping("/informes/delete/{id}")
  public String delete(@PathVariable("id") Long id, Model model) {
    //  informeRepositorio.deleteById(id);
    informeService.borrarInforme(id);

    model.addAttribute("tituloWeb", "Elimina informe");
    model.addAttribute("titulo", "Elimina informe");
    model.addAttribute("subtitulo", "Eliminado informe concreto de la BBDD");
//    model.addAttribute("informes", informeRepositorio.findAll());
    model.addAttribute("informes", informeService.getInformes());
    model.addAttribute("eliminado", true);
    return "informes/read";
  }

  @GetMapping("/informes/create")
  public String create(Model model) {
    model.addAttribute("tituloWeb", "Crear informe");
    model.addAttribute("titulo", "Crear informe");
    model.addAttribute("subtitulo", "Creando informe en la BBDD con Informe Command");
    model.addAttribute("informe", new InformesCommand());
    model.addAttribute("postForm", "/informes/create");
    return "informes/create";
  }

  @PostMapping("/informes/create")
  public String saveCreate(@Valid @ModelAttribute("informe") InformesCommand informe, BindingResult bindingResult, Model model) {

    if (bindingResult.hasErrors()) {
      System.out.println("Errores en la validación: " + bindingResult.getAllErrors());
      model.addAttribute("error", true);
      model.addAttribute("tituloWeb", "Crear informe");
      model.addAttribute("titulo", "Crear informe");
      model.addAttribute("subtitulo", "Creando informe en la BBDD");
      model.addAttribute("postForm", "/informes/create");
      return "informes/create";
    }

    model.addAttribute("tituloWeb", "Crear informe");
    model.addAttribute("titulo", "Crear informe");
    model.addAttribute("subtitulo", "Creado informe en la BBDD");
    System.out.println("Saving informe: " + informe);
    model.addAttribute("creado", true);
//    informeRepositorio.save(informe);
    informeService.saveInforme(informe);
//    model.addAttribute("informes", informeRepositorio.findAll());
    model.addAttribute("informes", informeService.getInformes());
    return "informes/read";
  }

  @RequestMapping("/informes/update/{id}")
  public String update(@PathVariable("id") Long id, Model model) {
    String ruta;
    ruta = "/informes/update/" + id;
    model.addAttribute("tituloWeb", "Actualizar informe");
    model.addAttribute("titulo", "Actualizar informe");
    model.addAttribute("subtitulo", "Actualizando informe en la BBDD");
    model.addAttribute("postForm", ruta);
    //  informeRepositorio.findById(id).ifPresent(o -> model.addAttribute("informe", o));
    model.addAttribute("informe", informeService.getByID(id));
    model.addAttribute("actualizando", true);
    return "informes/create";
  }

  @PostMapping("/informes/update/{id}")
  public String saveUpdate(@PathVariable("id") Long id, @Valid @ModelAttribute("informe") InformesCommand informe, BindingResult bindingResult, Model model) {
    String ruta;
    ruta = "/informes/update/" + id;
    if (bindingResult.hasErrors()) {
      System.out.println("Errores en la validación: " + bindingResult.getAllErrors());
      model.addAttribute("error", true);
      model.addAttribute("tituloWeb", "Crear informe");
      model.addAttribute("titulo", "Crear informe");
      model.addAttribute("subtitulo", "Creando informe en la BBDD");
      model.addAttribute("informe", informe);
      model.addAttribute("actualizando", true);
      model.addAttribute("postForm", ruta);
      return "informes/create";
    }

    model.addAttribute("tituloWeb", "Actualizar informe");
    model.addAttribute("titulo", "Actualizar informe");
    model.addAttribute("subtitulo", "Actualizado informe en la BBDD");
    System.out.println("Updating informe: " + informe);
//    informeRepositorio.save(informe);
    informeService.saveInforme(informe);

//    model.addAttribute("informes", informeRepositorio.findAll());
    model.addAttribute("informes", informeService.getInformes());
    model.addAttribute("actualizado", true);
    return "informes/read";
  }
}
