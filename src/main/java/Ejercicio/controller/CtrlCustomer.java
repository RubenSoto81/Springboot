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
import Ejercicio.entity.Customer;
import Ejercicio.service.CustomerService;

@Controller
public class CtrlCustomer {

  @Autowired
  private CustomerService customerService;

  @GetMapping("/customer/crear")
  public String createCapital(Model model) {
    model.addAttribute("tituloWeb", "Crear customer");
    model.addAttribute("titulo", "Crear customer");
    model.addAttribute("subtitulo", "Creando customer en la BBDD");
    model.addAttribute("customer", new Customer());
    model.addAttribute("postForm", "/customer/crear");
    return "customer/create";
  }

  @PostMapping("/customer/crear")
  public String saveCreate(@Valid @ModelAttribute("customer") Customer customer, BindingResult bindingResult, Model model) {

    if (bindingResult.hasErrors()) {
      System.out.println("Errores en la validación: " + bindingResult.getAllErrors());
      model.addAttribute("error", true);
      model.addAttribute("tituloWeb", "Crear customer");
      model.addAttribute("titulo", "Crear customer");
      model.addAttribute("subtitulo", "Creando customer en la BBDD");
      model.addAttribute("postForm", "/customer/crear");
      return "customer/create";
    }

    model.addAttribute("tituloWeb", "Crear customer");
    model.addAttribute("titulo", "Crear customer");
    model.addAttribute("subtitulo", "Creada customer en la BBDD");
    System.out.println("Saving customer: " + customer);
    model.addAttribute("creado", true);
    customerService.guardaCustomer(customer);
    model.addAttribute("customers", customerService.getCustomers());
    return "customer/read";
  }

  @RequestMapping("/customer/listar")
  public String readCapital(Model model) {
    model.addAttribute("tituloWeb", "Ver customers");
    model.addAttribute("titulo", "Ver customers");
    model.addAttribute("subtitulo", "Mostrando listado de customers de la BBDD");
    model.addAttribute("customers", customerService.getCustomers());
    return "customer/read";
  }

  @RequestMapping("/customer/ver/{id}")
  public String showCapital(@PathVariable("id") Long id, Model model) {
    model.addAttribute("tituloWeb", "Ver customer");
    model.addAttribute("titulo", "Ver customer");
    model.addAttribute("subtitulo", "Mostrando customer concreto de la BBDD");
    customerService.getByID(id).ifPresent(o -> model.addAttribute("customer", o));
    return "customer/detail";
  }

  @RequestMapping("/customer/update/{id}")
  public String update(@PathVariable("id") Long id, Model model) {
    String ruta;
    ruta = "/customer/update/" + id;
    model.addAttribute("tituloWeb", "Actualizar customer");
    model.addAttribute("titulo", "Actualizar customer");
    model.addAttribute("subtitulo", "Actualizando customer en la BBDD");
    model.addAttribute("postForm", ruta);
    model.addAttribute("customer", customerService.getByID(id));
    model.addAttribute("actualizando", true);
    return "customer/create";
  }

  @PostMapping("/customer/update/{id}")
  public String saveUpdate(@PathVariable("id") Long id, @Valid @ModelAttribute("customer") Customer customer, BindingResult bindingResult, Model model) {
    String ruta;
    ruta = "/customer/update/" + id;
    if (bindingResult.hasErrors()) {
      System.out.println("Errores en la validación: " + bindingResult.getAllErrors());
      model.addAttribute("error", true);
      model.addAttribute("tituloWeb", "Actualizar customer");
      model.addAttribute("titulo", "Actualizar customer");
      model.addAttribute("subtitulo", "Actualizando customer en la BBDD");
      model.addAttribute("customer", customer);
      model.addAttribute("actualizando", true);
      model.addAttribute("postForm", ruta);
      return "customer/create";
    }

    model.addAttribute("tituloWeb", "Actualizar customer");
    model.addAttribute("titulo", "Actualizar customer");
    model.addAttribute("subtitulo", "Actualizada customer en la BBDD");
    System.out.println("Updating customer: " + customer);
    customerService.guardaCustomer(customer);
    model.addAttribute("customers", customerService.getCustomers());
    model.addAttribute("actualizado", true);
    return "customer/read";
  }

  @RequestMapping("/customer/delete/{id}")
  public String delete(@PathVariable("id") Long id, Model model) {
    customerService.borraCustomer(id);
    model.addAttribute("tituloWeb", "Elimina customer");
    model.addAttribute("titulo", "Elimina customer");
    model.addAttribute("subtitulo", "Eliminado customer concreto de la BBDD");
    model.addAttribute("customers", customerService.getCustomers());
    model.addAttribute("eliminado", true);
    return "customer/read";
  }
}
