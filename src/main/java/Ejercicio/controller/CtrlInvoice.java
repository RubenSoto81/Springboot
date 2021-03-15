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
import Ejercicio.entity.Invoice;
import Ejercicio.service.CustomerService;
import Ejercicio.service.InvoiceService;

@Controller
public class CtrlInvoice {

  @Autowired
  private InvoiceService invoiceService;

  @Autowired
  private CustomerService customerService;

  @GetMapping("/invoice/crear")
  public String createCapital(Model model) {
    model.addAttribute("tituloWeb", "Crear invoice");
    model.addAttribute("titulo", "Crear invoice");
    model.addAttribute("subtitulo", "Creando invoice en la BBDD");
    model.addAttribute("invoice", new Invoice(0, false, 0L));
    model.addAttribute("customers", customerService.getCustomers());
    model.addAttribute("postForm", "/invoice/crear");
    return "invoice/create";
  }

  @PostMapping("/invoice/crear")
  public String saveCreate(@Valid @ModelAttribute("invoice") Invoice invoice, BindingResult bindingResult, Model model) {

    if (bindingResult.hasErrors()) {
      System.out.println("Errores en la validación: " + bindingResult.getAllErrors());
      model.addAttribute("error", true);
      model.addAttribute("tituloWeb", "Crear invoice");
      model.addAttribute("titulo", "Crear invoice");
      model.addAttribute("subtitulo", "Creando invoice en la BBDD");
      model.addAttribute("postForm", "/invoice/crear");
      return "invoice/create";
    }

    model.addAttribute("tituloWeb", "Crear invoice");
    model.addAttribute("titulo", "Crear invoice");
    model.addAttribute("subtitulo", "Creada invoice en la BBDD");
    System.out.println("Saving invoice: " + invoice);
    model.addAttribute("creado", true);
    invoiceService.guardaInvoice(invoice);
    model.addAttribute("invoices", invoiceService.getInvoices());
    return "invoice/read";
  }

  @RequestMapping("/invoice/listar")
  public String readCapital(Model model) {
    model.addAttribute("tituloWeb", "Ver invoices");
    model.addAttribute("titulo", "Ver invoices");
    model.addAttribute("subtitulo", "Mostrando listado de invoices de la BBDD");
    model.addAttribute("invoices", invoiceService.getInvoices());
    return "invoice/read";
  }

  @RequestMapping("/invoice/ver/{id}")
  public String showCapital(@PathVariable("id") Long id, Model model) {
    model.addAttribute("tituloWeb", "Ver invoice");
    model.addAttribute("titulo", "Ver invoice");
    model.addAttribute("subtitulo", "Mostrando invoice concreto de la BBDD");
    invoiceService.getByID(id).ifPresent(o -> model.addAttribute("invoice", o));
    return "invoice/detail";
  }

  @RequestMapping("/invoice/update/{id}")
  public String update(@PathVariable("id") Long id, Model model) {
    String ruta;
    ruta = "/invoice/update/" + id;
    model.addAttribute("tituloWeb", "Actualizar invoice");
    model.addAttribute("titulo", "Actualizar invoice");
    model.addAttribute("subtitulo", "Actualizando invoice en la BBDD");
    model.addAttribute("postForm", ruta);
    model.addAttribute("invoice", invoiceService.getByID(id));
    model.addAttribute("actualizando", true);
    return "invoice/create";
  }

  @PostMapping("/invoice/update/{id}")
  public String saveUpdate(@PathVariable("id") Long id, @Valid @ModelAttribute("invoice") Invoice invoice, BindingResult bindingResult, Model model) {
    String ruta;
    ruta = "/invoice/update/" + id;
    if (bindingResult.hasErrors()) {
      System.out.println("Errores en la validación: " + bindingResult.getAllErrors());
      model.addAttribute("error", true);
      model.addAttribute("tituloWeb", "Actualizar invoice");
      model.addAttribute("titulo", "Actualizar invoice");
      model.addAttribute("subtitulo", "Actualizando invoice en la BBDD");
      model.addAttribute("invoice", invoice);
      model.addAttribute("actualizando", true);
      model.addAttribute("postForm", ruta);
      return "invoice/create";
    }

    model.addAttribute("tituloWeb", "Actualizar invoice");
    model.addAttribute("titulo", "Actualizar invoice");
    model.addAttribute("subtitulo", "Actualizada invoice en la BBDD");
    System.out.println("Updating invoice: " + invoice);
    invoiceService.guardaInvoice(invoice);
    model.addAttribute("invoices", invoiceService.getInvoices());
    model.addAttribute("actualizado", true);
    return "invoice/read";
  }

  @RequestMapping("/invoice/delete/{id}")
  public String delete(@PathVariable("id") Long id, Model model) {
    invoiceService.borraInvoice(id);
    model.addAttribute("tituloWeb", "Elimina invoice");
    model.addAttribute("titulo", "Elimina invoice");
    model.addAttribute("subtitulo", "Eliminado invoice concreto de la BBDD");
    model.addAttribute("invoices", invoiceService.getInvoices());
    model.addAttribute("eliminado", true);
    return "invoice/read";
  }
}
