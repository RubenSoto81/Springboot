package Ejercicio.controller;

import Ejercicio.service.FilesUpload;
import java.io.IOException;
import org.apache.tomcat.util.http.fileupload.impl.FileSizeLimitExceededException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class CtrlSubirArchivo {

  @Autowired
  private FilesUpload uploadFileService;

  @RequestMapping("/admin/upload")
  public String subirArchivo(Model model) {
    model.addAttribute("tituloWeb", "Subir archivo");
    model.addAttribute("titulo", "Subir archivo");
    model.addAttribute("subtitulo", "Subir archivo del ejercicio 129");
    return "admin/subir";
  }

  @PostMapping("/admin/upload")
  public String uploadFile(@RequestParam("file") MultipartFile file, Model model) {
    if (file.isEmpty()) {
      model.addAttribute("error", true);
      model.addAttribute("tituloWeb", "Subir archivo");
      model.addAttribute("titulo", "Subir archivo");
      model.addAttribute("subtitulo", "Subir archivo del ejercicio 129. No había archivo");
      return "admin/subir";
    }

    try {
      uploadFileService.saveFile(file);
    } catch (FileSizeLimitExceededException e) {
      e.printStackTrace();
      model.addAttribute("error", true);
      model.addAttribute("tituloWeb", "Subir archivo");
      model.addAttribute("titulo", "Subir archivo");
      model.addAttribute("subtitulo", "Subir archivo del ejercicio 129. El archivo era demasiado grande");
      return "admin/subir";
    } catch (IOException e) {
      e.printStackTrace();
      model.addAttribute("error", true);
      model.addAttribute("tituloWeb", "Subir archivo");
      model.addAttribute("titulo", "Subir archivo");
      model.addAttribute("subtitulo", "Subir archivo del ejercicio 129");
      return "admin/subir";
    }

    model.addAttribute("tituloWeb", "Subir archivo");
    model.addAttribute("titulo", "Subir archivo");
    model.addAttribute("subtitulo", "Subir archivo del ejercicio 129");

    model.addAttribute("subido", true);

    return "admin/subir";
  }

}
