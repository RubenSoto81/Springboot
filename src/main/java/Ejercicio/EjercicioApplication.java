package Ejercicio;

import Ejercicio.repository.PaisRepository;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import Ejercicio.entity.Capital;
import Ejercicio.entity.Pais;
import Ejercicio.service.CapitalService;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class EjercicioApplication implements CommandLineRunner {

  @Autowired
  private CapitalService capitalService;

  @Autowired
  private PaisRepository paisRepository;

  public static void main(String[] args) {
    SpringApplication.run(EjercicioApplication.class, args);
  }

  public void run(String... args) throws Exception {
    System.out.println("Ya he arrancado: " + LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM)));

    //Aqu� hago las consultas
    Iterable<Capital> capitales = capitalService.getCapitales();
    Iterable<Pais> paises = paisRepository.findAll();

    Pais p1 = paisRepository.findByName("Spain");
    Capital capitalBuscada = new Capital();
    capitalBuscada.setId(4L);
    Pais p2 = paisRepository.findByCapital(capitalBuscada);

    List<Capital> capitalesMayorMillonHab = capitalService.findByHabitantesGreaterThan(1000000L);
    List<Capital> capitalesMenorMillonHab = capitalService.findByHabitantesLessThan(1000000L);
    List<Pais> paisMayor20MillonesHab = paisRepository.findByPoblacionGreaterThan(20000000L);
    List<Pais> paisMenor20MillonesHab = paisRepository.findByPoblacionLessThan(20000000L);

    List<Pais> PaisConCapitalesMayorMillonHab = new ArrayList<>();
    capitalesMayorMillonHab.forEach((t) -> {
      PaisConCapitalesMayorMillonHab.add(paisRepository.findByCapital(t));
    });

    List<Pais> PaisConCapitalesMenorMillonHab = new ArrayList<>();
    capitalesMenorMillonHab.forEach((t) -> {
      PaisConCapitalesMenorMillonHab.add(paisRepository.findByCapital(t));
    });

    //A partir de aquí saco la información por pantalla
    //Así no se mezcla
    System.out.println("------------------------------------------------------------------------");
    System.out.println("------------------------------------------------------------------------");
    System.out.println("------------------------------------------------------------------------");
    System.out.println("------------------------------------------------------------------------");
    System.out.println("------------------------------------------------------------------------");
    System.out.println("------------------------------------------------------------------------");
    System.out.println("------------------------------------------------------------------------");
    System.out.println("------------------------------------------------------------------------");
    System.out.println("------------------------------------------------------------------------");
    System.out.println("------------------------------------------------------------------------");
    System.out.println("Mostrar todas las capitales");
    System.out.println("------------------------------------------------------------------------");
    capitales.forEach(t -> System.out.println(t));
    System.out.println("------------------------------------------------------------------------");
    System.out.println("Mostrar todos los paises");
    System.out.println("------------------------------------------------------------------------");
    paises.forEach(t -> System.out.println(t));
    System.out.println("------------------------------------------------------------------------");
    System.out.println("Mostrar país Spain");
    System.out.println("------------------------------------------------------------------------");
    System.out.println(p1);
    System.out.println("------------------------------------------------------------------------");
    System.out.println("Mostrar país con capital Paris (id=4)");
    System.out.println("------------------------------------------------------------------------");
    System.out.println(p2);
    System.out.println("------------------------------------------------------------------------");
    System.out.println("Mostrar todas las capitales con más de 1 millón de habitantes");
    System.out.println("------------------------------------------------------------------------");
    capitalesMayorMillonHab.forEach(t -> System.out.println(t));
    System.out.println("------------------------------------------------------------------------");
    System.out.println("Mostrar todas las capitales con menos de 1 millón de habitantes");
    System.out.println("------------------------------------------------------------------------");
    capitalesMenorMillonHab.forEach(t -> System.out.println(t));
    System.out.println("------------------------------------------------------------------------");
    System.out.println("Mostrar todos los paises con más de 20 millones de habitantes");
    System.out.println("------------------------------------------------------------------------");
    paisMayor20MillonesHab.forEach(t -> System.out.println(t));
    System.out.println("------------------------------------------------------------------------");
    System.out.println("Mostrar todos los paises con menos de 20 millones de habitantes");
    System.out.println("------------------------------------------------------------------------");
    paisMenor20MillonesHab.forEach(t -> System.out.println(t));
    System.out.println("------------------------------------------------------------------------");
    System.out.println("Mostrar todos los paises con capitales de más de 1 millón de habitantes");
    System.out.println("------------------------------------------------------------------------");
    PaisConCapitalesMayorMillonHab.forEach(t -> System.out.println(t));
    System.out.println("------------------------------------------------------------------------");
    System.out.println("Mostrar todos los paises con capitales de menos de 1 millón de habitantes");
    System.out.println("------------------------------------------------------------------------");
    PaisConCapitalesMenorMillonHab.forEach(t -> System.out.println(t));

  }

}
