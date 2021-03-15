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
import Ejercicio.entity.Clientes;
import Ejercicio.repository.ClientesRepository;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CtrlClientes {

  @Autowired
  private ClientesRepository clienteRepositorio;

  @RequestMapping("/clientes/listar")
  public String read(Model model) {
    model.addAttribute("tituloWeb", "Ver clientes");
    model.addAttribute("titulo", "Ver clientes");
    model.addAttribute("subtitulo", "Mostrando listado de clientes de la BBDD");
    model.addAttribute("clientes", clienteRepositorio.findAll());
    return "clientes/read";
  }

  @RequestMapping("/clientes/ver/{id}")
  public String show(@PathVariable("id") Long id, Model model) {
    model.addAttribute("tituloWeb", "Ver cliente");
    model.addAttribute("titulo", "Ver cliente");
    model.addAttribute("subtitulo", "Mostrando cliente concreto de la BBDD");

    clienteRepositorio.findById(id).ifPresent(o -> model.addAttribute("cliente", o));

    return "clientes/detail";
  }

  @RequestMapping("/clientes/delete/{id}")
  public String delete(@PathVariable("id") Long id, Model model) {
    clienteRepositorio.deleteById(id);
    model.addAttribute("tituloWeb", "Elimina cliente");
    model.addAttribute("titulo", "Elimina cliente");
    model.addAttribute("subtitulo", "Eliminado cliente concreto de la BBDD");
    model.addAttribute("clientes", clienteRepositorio.findAll());
    model.addAttribute("eliminado", true);
    return "clientes/read";
  }

  @GetMapping("/clientes/create")
  public String create(Model model) {
    model.addAttribute("tituloWeb", "Crear cliente");
    model.addAttribute("titulo", "Crear cliente");
    model.addAttribute("subtitulo", "Creando cliente en la BBDD");
    model.addAttribute("cliente", new Clientes());
    model.addAttribute("postForm", "/clientes/create");
    return "clientes/create";
  }

  @PostMapping("/clientes/create")
  public String saveCreate(@Valid @ModelAttribute("cliente") Clientes cliente, BindingResult bindingResult, Model model) {

    if (bindingResult.hasErrors()) {
      System.out.println("Errores en la validación: " + bindingResult.getAllErrors());
      model.addAttribute("error", true);
      model.addAttribute("tituloWeb", "Crear cliente");
      model.addAttribute("titulo", "Crear cliente");
      model.addAttribute("subtitulo", "Creando cliente en la BBDD");
      model.addAttribute("postForm", "/clientes/create");
      return "clientes/create";
    }

    model.addAttribute("tituloWeb", "Crear cliente");
    model.addAttribute("titulo", "Crear cliente");
    model.addAttribute("subtitulo", "Creado cliente en la BBDD");
    System.out.println("Saving cliente: " + cliente);
    model.addAttribute("creado", true);
    clienteRepositorio.save(cliente);
    model.addAttribute("clientes", clienteRepositorio.findAll());
    return "clientes/read";
  }

  @RequestMapping("/clientes/update/{id}")
  public String update(@PathVariable("id") Long id, Model model) {
    String ruta;
    ruta = "/clientes/update/" + id;
    model.addAttribute("tituloWeb", "Actualizar cliente");
    model.addAttribute("titulo", "Actualizar cliente");
    model.addAttribute("subtitulo", "Actualizando cliente en la BBDD");
    model.addAttribute("postForm", ruta);
    model.addAttribute("cliente", clienteRepositorio.findById(id));
    model.addAttribute("actualizando", true);
    return "clientes/create";
  }

  @PostMapping("/clientes/update/{id}")
  public String saveUpdate(@PathVariable("id") Long id, @Valid @ModelAttribute("cliente") Clientes cliente, BindingResult bindingResult, Model model) {
    String ruta;
    ruta = "/clientes/update/" + id;
    if (bindingResult.hasErrors()) {
      System.out.println("Errores en la validación: " + bindingResult.getAllErrors());
      model.addAttribute("error", true);
      model.addAttribute("tituloWeb", "Crear cliente");
      model.addAttribute("titulo", "Crear cliente");
      model.addAttribute("subtitulo", "Creando cliente en la BBDD");
      model.addAttribute("cliente", cliente);
      model.addAttribute("actualizando", true);
      model.addAttribute("postForm", ruta);
      return "clientes/create";
    }

    model.addAttribute("tituloWeb", "Actualizar cliente");
    model.addAttribute("titulo", "Actualizar cliente");
    model.addAttribute("subtitulo", "Actualizado cliente en la BBDD");
    System.out.println("Updating cliente: " + cliente);
    clienteRepositorio.save(cliente);
    model.addAttribute("clientes", clienteRepositorio.findAll());
    model.addAttribute("actualizado", true);
    return "clientes/read";
  }

  @RequestMapping("/clientes/listar/pornombre")
  public String readClientesNombre(@RequestParam("nombre") String nombre, Model model) {
    if ((clienteRepositorio.findByNombreContaining(nombre)).isEmpty()) {
      System.out.println("lista vacía");
      model.addAttribute("tituloWeb", "No se ha encontrado");
      model.addAttribute("titulo", "ERROR");
      model.addAttribute("subtitulo", "No se ha encontrado ningún cliente con ese nombre");
      model.addAttribute("error", true);
      return "clientes/read";
    } else {
      model.addAttribute("clientes", clienteRepositorio.findByNombreContaining(nombre));
      model.addAttribute("tituloWeb", "Ver clientes");
      model.addAttribute("titulo", "Ver clientes");
      model.addAttribute("subtitulo", "Mostrando listado de clientes de la BBDD");
      return "clientes/read";
    }
  }

  @RequestMapping("/clientes/listar/porapellido")
  public String readClientesApellido(@RequestParam("apellido") String apellido, Model model) {
    if ((clienteRepositorio.findByApellidoContaining(apellido)).isEmpty()) {
      System.out.println("lista vacía");
      model.addAttribute("tituloWeb", "No se ha encontrado");
      model.addAttribute("titulo", "ERROR");
      model.addAttribute("subtitulo", "No se ha encontrado ningún cliente con ese apellido");
      model.addAttribute("error", true);
      return "clientes/read";
    } else {
      model.addAttribute("clientes", clienteRepositorio.findByApellidoContaining(apellido));
      model.addAttribute("tituloWeb", "Ver clientes");
      model.addAttribute("titulo", "Ver clientes");
      model.addAttribute("subtitulo", "Mostrando listado de clientes de la BBDD");
      return "clientes/read";
    }
  }

  @RequestMapping("/clientes/listar/porciudad")
  public String readClientesCiudad(@RequestParam("ciudad") String ciudad, Model model) {
    if ((clienteRepositorio.findByCiudadContaining(ciudad)).isEmpty()) {
      System.out.println("lista vacía");
      model.addAttribute("tituloWeb", "No se ha encontrado");
      model.addAttribute("titulo", "ERROR");
      model.addAttribute("subtitulo", "No se ha encontrado ningún cliente de esa ciudad");
      model.addAttribute("error", true);
      return "clientes/read";
    } else {
      model.addAttribute("clientes", clienteRepositorio.findByCiudadContaining(ciudad));
      model.addAttribute("tituloWeb", "Ver clientes");
      model.addAttribute("titulo", "Ver clientes");
      model.addAttribute("subtitulo", "Mostrando listado de clientes de la BBDD");
      return "clientes/read";
    }
  }

  @RequestMapping("/clientes/listar/poridmayor")
  public String readClientesIdMayorIgual(@RequestParam("id") String id, Model model) {
    if ((clienteRepositorio.findByIdGreaterThanEqualOrderByApellido(Long.parseLong(id))).isEmpty()) {
      System.out.println("lista vacía");
      model.addAttribute("tituloWeb", "No se ha encontrado");
      model.addAttribute("titulo", "ERROR");
      model.addAttribute("subtitulo", "No se ha encontrado ningún cliente con ese apellido");
      model.addAttribute("error", true);
      return "clientes/read";
    } else {
      model.addAttribute("clientes", clienteRepositorio.findByIdGreaterThanEqualOrderByApellido(Long.parseLong(id)));
      model.addAttribute("tituloWeb", "Ver clientes");
      model.addAttribute("titulo", "Ver clientes");
      model.addAttribute("subtitulo", "Mostrando listado de clientes de la BBDD");
      return "clientes/read";
    }
  }

}
