package Ejercicio.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CtrlPrincipal {

  @Value("${application.controller.tituloWeb}")
  private String tituloWeb;

  @Value("${application.controller.titulo}")
  private String titulo;

  @Value("${application.controller.subtitulo}")
  private String subtitulo;

  @RequestMapping("/")
  public String pral(Model model) {
    model.addAttribute("tituloWeb", tituloWeb);
    model.addAttribute("titulo", titulo);
    model.addAttribute("subtitulo", subtitulo);
    return "index";
  }

  @RequestMapping("/public/sobrenosotros")
  public String about(Model model) {
    model.addAttribute("tituloWeb", tituloWeb);
    model.addAttribute("titulo", titulo);
    model.addAttribute("subtitulo", "Sobre nosotros");
    return "admin/about";
  }

  @RequestMapping("/public/nuestraempresa")
  public String nuestraEmpresa(Model model) {
    model.addAttribute("tituloWeb", tituloWeb);
    model.addAttribute("titulo", titulo);
    model.addAttribute("subtitulo", "Nuestra empresa");
    return "admin/empresa";
  }

  @RequestMapping("/public/servicios")
  public String servicios(Model model) {
    model.addAttribute("tituloWeb", tituloWeb);
    model.addAttribute("titulo", titulo);
    model.addAttribute("subtitulo", "Servicios libres");
    return "admin/servicios";
  }

  @RequestMapping("/public/tusservicios")
  public String tusServicios(Model model) {
    model.addAttribute("tituloWeb", tituloWeb);
    model.addAttribute("titulo", titulo);
    model.addAttribute("subtitulo", "Tus Servicios");
    return "admin/tusservicios";
  }
}
