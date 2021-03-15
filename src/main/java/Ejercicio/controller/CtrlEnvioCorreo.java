package Ejercicio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import Ejercicio.model.Headers;
import Ejercicio.service.EmailSender;
import Ejercicio.service.FilesUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class CtrlEnvioCorreo {

  @Autowired
  private EmailSender emailSenderImpl;

  @Autowired
  private FilesUpload uploadFileService;

  @Value("${application.controller.tituloWeb}")
  private String tituloWeb;

  @Value("${application.controller.titulo}")
  private String titulo;

  @Value("${application.controller.subtitulo}")
  private String subtitulo;

  @GetMapping("/admin/enviarcorreo")
  public String enviarcorreo(Model model) {
    model.addAttribute("headers", new Headers());
    model.addAttribute("postForm", "/admin/enviarcorreo");
    model.addAttribute("tituloWeb", tituloWeb);
    model.addAttribute("titulo", titulo);
    model.addAttribute("subtitulo", "Página de envío de correo electrónico");
    return "admin/correoForm";
  }

  @PostMapping(value = "/admin/enviarcorreo")
  public String enviarcorreoenviado(Model model, @ModelAttribute("headers") Headers headers) throws Exception {
    emailSenderImpl.sendMessage(headers);
    model.addAttribute("tituloWeb", tituloWeb);
    model.addAttribute("titulo", titulo);
    model.addAttribute("subtitulo", "Se ha enviado el correo correctamente");
    return "index";
  }

  @GetMapping("/admin/enviarcorreo/adjunto")
  public String enviarcorreoAdjunto(Model model) {
    model.addAttribute("headers", new Headers());
    model.addAttribute("postForm", "/admin/enviarcorreo/adjunto");
    model.addAttribute("tituloWeb", tituloWeb);
    model.addAttribute("titulo", titulo);
    model.addAttribute("subtitulo", "Página de envío de correo electrónico");
    return "admin/correoFormAdjunto";
  }

  @PostMapping(value = "/admin/enviarcorreo/adjunto")
  public String enviarcorreoenviadoAdjunto(@RequestParam("file") MultipartFile file, Model model, @ModelAttribute("headers") Headers headers) throws Exception {
    String ruta = ".//src//main//resources//static//files//";
    uploadFileService.saveFile(file);
    ruta += file.getOriginalFilename();
    emailSenderImpl.sendWithAttachment(headers, ruta);
    model.addAttribute("tituloWeb", tituloWeb);
    model.addAttribute("titulo", titulo);
    model.addAttribute("subtitulo", "Se ha enviado el correo correctamente");
    return "index";
  }
}
