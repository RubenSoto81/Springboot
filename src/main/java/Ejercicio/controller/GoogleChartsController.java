package Ejercicio.controller;

import Ejercicio.entity.Donut;
import Ejercicio.repository.ClientesRepository;
import Ejercicio.repository.DonutRepository;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GoogleChartsController {

  @Autowired
  private ClientesRepository clienteRepositorio;

  @Autowired
  private DonutRepository donutRepositorio;

  @Value("${application.controller.tituloWeb}")
  private String tituloWeb;

  @Value("${application.controller.titulo}")
  private String titulo;

  @Value("${application.controller.subtitulo}")
  private String subtitulo;

  @GetMapping("/chart")
  public String getPieChart(Model model) {
    Map<String, Integer> graphData = new TreeMap<>();
    graphData.put("2013", 15000);
    graphData.put("2014", 12560);
    graphData.put("2015", 3856);
    graphData.put("2016", 1470);
    graphData.put("2017", 12560);
    graphData.put("2018", 3856);
    graphData.put("2019", 19807);

    model.addAttribute("tituloWeb", tituloWeb);
    model.addAttribute("titulo", titulo);
    model.addAttribute("subtitulo", "Google Charts Example - Spring Boot");
    model.addAttribute("chartData", graphData);
    model.addAttribute("chartTitulo", "Estadísticas del blog");
    model.addAttribute("chartTituloH", "Años");
    model.addAttribute("chartTituloV", "Contador de visitas");
    model.addAttribute("columna1tipo", "string");
    model.addAttribute("columna1nombre", "Año");
    model.addAttribute("columna2tipo", "number");
    model.addAttribute("columna2nombre", "Visitas");

    Iterable<Donut> misDonuts = donutRepositorio.findAll();
    ArrayList<ArrayList> donutsData = new ArrayList();
    ArrayList o = new ArrayList();
    o.add("Nombre");
    o.add("Género");
    o.add("Edad");
    o.add("Donuts comidos");
    donutsData.add(o);
    for (Donut miDonut : misDonuts) {
      o = new ArrayList();
      o.add(miDonut.getNombre());
      o.add(miDonut.getGenero());
      o.add(miDonut.getEdad());
      o.add(miDonut.getDonuts_comidos());
      donutsData.add(o);
    }
    model.addAttribute("donutsData", donutsData);
    model.addAttribute("chartFiltroEdad", "Filtro edad:");
    model.addAttribute("chartFiltroGenero", "Selección de género");

    return "google-charts";
  }
}
