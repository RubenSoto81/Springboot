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
import Ejercicio.repository.PaisRepository;
import Ejercicio.entity.Pais;
import Ejercicio.entity.Capital;
import Ejercicio.service.CapitalService;
import java.util.List;

@Controller
public class CtrlCapitalPais {

	@Autowired
	private PaisRepository paisRepository;

	@Autowired
	private CapitalService capitalService;

	@RequestMapping("/pais/listar")
	public String read(Model model) {
		model.addAttribute("tituloWeb", "Ver paises");
		model.addAttribute("titulo", "Ver paises");
		model.addAttribute("subtitulo", "Mostrando listado de paises de la BBDD");
		model.addAttribute("paises", paisRepository.findAll());
		return "pais/read";
	}

	@RequestMapping("/pais/ver/{id}")
	public String show(@PathVariable("id") Long id, Model model) {
		model.addAttribute("tituloWeb", "Ver pais");
		model.addAttribute("titulo", "Ver pais");
		model.addAttribute("subtitulo", "Mostrando pais concreto de la BBDD");
		paisRepository.findById(id).ifPresent(o -> model.addAttribute("pais", o));
		return "pais/detail";
	}

	@GetMapping("/pais/crear")
	public String createPais(Model model) {
		model.addAttribute("tituloWeb", "Crear país");
		model.addAttribute("titulo", "Crear país");
		model.addAttribute("subtitulo", "Creando país en la BBDD");
		model.addAttribute("pais", new Pais());
		List<Capital> capitales = capitalService.getCapitalesSinPais();
		model.addAttribute("capitales", capitales);
		model.addAttribute("postForm", "/pais/crear");
		return "pais/create";
	}

	@PostMapping("/pais/crear")
	public String saveCreatePais(@Valid @ModelAttribute("pais") Pais pais, BindingResult bindingResult, Model model) {

		if (bindingResult.hasErrors()) {
			System.out.println("Errores en la validación: " + bindingResult.getAllErrors());
			model.addAttribute("error", true);
			model.addAttribute("tituloWeb", "Crear país");
			model.addAttribute("titulo", "Crear país");
			model.addAttribute("subtitulo", "Creando país en la BBDD");
			List<Capital> capitales = capitalService.getCapitalesSinPais();
			model.addAttribute("capitales", capitales);
			model.addAttribute("postForm", "/pais/crear");
			return "pais/create";
		}

		model.addAttribute("tituloWeb", "Crear país");
		model.addAttribute("titulo", "Crear país");
		model.addAttribute("subtitulo", "Creado país en la BBDD");
		System.out.println("Saving país: " + pais);
		model.addAttribute("creado", true);
		paisRepository.save(pais);
		model.addAttribute("paises", paisRepository.findAll());
		return "pais/read";
	}

	@RequestMapping("/pais/delete/{id}")
	public String deletePais(@PathVariable("id") Long id, Model model) {
		paisRepository.deleteById(id);
		model.addAttribute("tituloWeb", "Elimina país");
		model.addAttribute("titulo", "Elimina país");
		model.addAttribute("subtitulo", "Eliminado país concreto de la BBDD");
		model.addAttribute("eliminado", true);
		model.addAttribute("paises", paisRepository.findAll());
		return "pais/read";
	}

	@RequestMapping("/pais/update/{id}")
	public String updatePais(@PathVariable("id") Long id, Model model) {
		String ruta;
		ruta = "/pais/update/" + id;
		model.addAttribute("tituloWeb", "Actualizar país");
		model.addAttribute("titulo", "Actualizar país");
		model.addAttribute("subtitulo", "Actualizando país en la BBDD");
		model.addAttribute("postForm", ruta);
		model.addAttribute("pais", paisRepository.findById(id));
		List<Capital> capitales = capitalService.getCapitalesSinPais();
		capitales.add(paisRepository.findById(id).get().getCapital());
		model.addAttribute("capitales", capitales);
		model.addAttribute("actualizando", true);
		return "pais/create";
	}

	@PostMapping("/pais/update/{id}")
	public String saveUpdatePais(@PathVariable("id") Long id, @Valid @ModelAttribute("pais") Pais pais,
			BindingResult bindingResult, Model model) {
		String ruta;
		ruta = "/pais/update/" + id;
		if (bindingResult.hasErrors()) {
			System.out.println("Errores en la validación: " + bindingResult.getAllErrors());
			model.addAttribute("error", true);
			model.addAttribute("tituloWeb", "Actualizar país");
			model.addAttribute("titulo", "Actualizar país");
			model.addAttribute("subtitulo", "Actualizando país en la BBDD");
			List<Capital> capitales = capitalService.getCapitalesSinPais();
			capitales.add(paisRepository.findById(id).get().getCapital());
			model.addAttribute("capitales", capitales);
			model.addAttribute("pais", pais);
			model.addAttribute("actualizando", true);
			model.addAttribute("postForm", ruta);
			return "pais/create";
		}

		model.addAttribute("tituloWeb", "Actualizar país");
		model.addAttribute("titulo", "Actualizar país");
		model.addAttribute("subtitulo", "Actualizada país en la BBDD");
		System.out.println("Updating capital: " + pais);
		paisRepository.save(pais);
		model.addAttribute("actualizado", true);
		model.addAttribute("paises", paisRepository.findAll());
		return "pais/read";
	}

	// Operaciones con capital
	//
	@GetMapping("/pais/capital/crear")
	public String createCapital(Model model) {
		model.addAttribute("tituloWeb", "Crear capital");
		model.addAttribute("titulo", "Crear capital");
		model.addAttribute("subtitulo", "Creando capital en la BBDD");
		model.addAttribute("capital", new Capital());
		model.addAttribute("postForm", "/pais/capital/crear");
		return "pais/capital/create";
	}

	@PostMapping("/pais/capital/crear")
	public String saveCreate(@Valid @ModelAttribute("capital") Capital capital, BindingResult bindingResult,
			Model model) {

		if (bindingResult.hasErrors()) {
			System.out.println("Errores en la validación: " + bindingResult.getAllErrors());
			model.addAttribute("error", true);
			model.addAttribute("tituloWeb", "Crear capital");
			model.addAttribute("titulo", "Crear capital");
			model.addAttribute("subtitulo", "Creando capital en la BBDD");
			model.addAttribute("postForm", "/pais/capital/crear");
			return "pais/capital/create";
		}

		model.addAttribute("tituloWeb", "Crear capital");
		model.addAttribute("titulo", "Crear capital");
		model.addAttribute("subtitulo", "Creada capital en la BBDD");
		System.out.println("Saving informe: " + capital);
		model.addAttribute("creado", true);
		capitalService.guardaCapital(capital);
		model.addAttribute("capitales", capitalService.getCapitales());
		return "pais/capital/read";
	}

	@RequestMapping("/pais/capital/listar")
	public String readCapital(Model model) {
		model.addAttribute("tituloWeb", "Ver capitales");
		model.addAttribute("titulo", "Ver capitales");
		model.addAttribute("subtitulo", "Mostrando listado de capitales de la BBDD");
		model.addAttribute("capitales", capitalService.getCapitales());
		return "pais/capital/read";
	}

	@RequestMapping("/pais/capital/ver/{id}")
	public String showCapital(@PathVariable("id") Long id, Model model) {
		model.addAttribute("tituloWeb", "Ver capital");
		model.addAttribute("titulo", "Ver capital");
		model.addAttribute("subtitulo", "Mostrando capital concreto de la BBDD");
		capitalService.getByID(id).ifPresent(o -> model.addAttribute("capital", o));
		return "pais/capital/detail";
	}

	@RequestMapping("/pais/capital/update/{id}")
	public String update(@PathVariable("id") Long id, Model model) {
		String ruta;
		ruta = "/pais/capital/update/" + id;
		model.addAttribute("tituloWeb", "Actualizar capital");
		model.addAttribute("titulo", "Actualizar capital");
		model.addAttribute("subtitulo", "Actualizando capital en la BBDD");
		model.addAttribute("postForm", ruta);
		model.addAttribute("capital", capitalService.getByID(id));
		model.addAttribute("actualizando", true);
		return "pais/capital/create";
	}

	@PostMapping("/pais/capital/update/{id}")
	public String saveUpdate(@PathVariable("id") Long id, @Valid @ModelAttribute("capital") Capital capital,
			BindingResult bindingResult, Model model) {
		String ruta;
		ruta = "/pais/capital/update/" + id;
		if (bindingResult.hasErrors()) {
			System.out.println("Errores en la validación: " + bindingResult.getAllErrors());
			model.addAttribute("error", true);
			model.addAttribute("tituloWeb", "Actualizar capital");
			model.addAttribute("titulo", "Actualizar capital");
			model.addAttribute("subtitulo", "Actualizando capital en la BBDD");
			model.addAttribute("capital", capital);
			model.addAttribute("actualizando", true);
			model.addAttribute("postForm", ruta);
			return "pais/capital/create";
		}

		model.addAttribute("tituloWeb", "Actualizar capital");
		model.addAttribute("titulo", "Actualizar capital");
		model.addAttribute("subtitulo", "Actualizada capital en la BBDD");
		System.out.println("Updating capital: " + capital);
		capitalService.guardaCapital(capital);
		model.addAttribute("capitales", capitalService.getCapitales());
		model.addAttribute("actualizado", true);
		return "pais/capital/read";
	}

	@RequestMapping("/pais/capital/delete/{id}")
	public String delete(@PathVariable("id") Long id, Model model) {
		capitalService.borraCapital(id);
		model.addAttribute("tituloWeb", "Elimina capital");
		model.addAttribute("titulo", "Elimina capital");
		model.addAttribute("subtitulo", "Eliminada capital concreto de la BBDD");
		model.addAttribute("capitales", capitalService.getCapitales());
		model.addAttribute("eliminado", true);
		return "pais/capital/read";
	}
}
