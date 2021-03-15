package Ejercicio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import Ejercicio.entity.User;
import Ejercicio.service.UserService;
import org.springframework.beans.factory.annotation.Value;

@Controller
public class CtrlLoginRegister {

  private UserService userService;

  @Value("${application.controller.tituloWeb}")
  private String tituloWeb;

  @Value("${application.controller.titulo}")
  private String titulo;

  @Value("${application.controller.subtitulo}")
  private String subtitulo;

  public CtrlLoginRegister(UserService userService) {
    this.userService = userService;
  }

  @GetMapping("/login")
  public String loginPage(Model model) {
    model.addAttribute("tituloWeb", tituloWeb);
    model.addAttribute("titulo", titulo);
    model.addAttribute("subtitulo", "Página de inicio de sesión");
    return "admin/login";
  }

  @GetMapping("/register")
  public String registerPage(Model model) {
    model.addAttribute("user", new User());
    model.addAttribute("postForm", "/register");
    model.addAttribute("tituloWeb", tituloWeb);
    model.addAttribute("titulo", titulo);
    model.addAttribute("subtitulo", "Página de registro de administrador");
    return "admin/register";
  }

  @PostMapping(value = "/register")
  public String createNewUser(User user, BindingResult bindingResult, Model model) {
    User userExists = userService.findUserByUsername(user.getUsername());
    if (userExists != null) {
      model.addAttribute("message", "Username YA registrado");
      model.addAttribute("postForm", "/register");
      return "admin/register";
    } else {
      userService.saveUser(user, 3);
      model.addAttribute("message", "¡Administrador registrado con exito!");
      return "admin/login";
    }
  }

  @GetMapping("/registeruser")
  public String registerUser(Model model) {
    model.addAttribute("user", new User());
    model.addAttribute("postForm", "/registeruser");
    model.addAttribute("tituloWeb", tituloWeb);
    model.addAttribute("titulo", titulo);
    model.addAttribute("subtitulo", "Página de registro de usuario");
    return "admin/register";
  }

  @PostMapping(value = "/registeruser")
  public String createNewUserUser(User user, BindingResult bindingResult, Model model) {
    User userExists = userService.findUserByUsername(user.getUsername());
    if (userExists != null) {
      model.addAttribute("message", "Username YA registrado");
      model.addAttribute("postForm", "/registeruser");
      return "admin/register";
    } else {
      userService.saveUser(user, 2);
      model.addAttribute("message", "¡Usuario registrado con exito!");
      return "admin/login";
    }
  }

  @GetMapping("/access-denied")
  public String accesoDenegadoPage(Model model) {
    model.addAttribute("tituloWeb", tituloWeb);
    model.addAttribute("titulo", titulo);
    model.addAttribute("subtitulo", "Ejercicio de control de acceso en BBDD. Página del administrador");
    return "admin/accesoDenegado";
  }

}
