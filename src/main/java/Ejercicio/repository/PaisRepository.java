package Ejercicio.repository;

import Ejercicio.entity.Capital;
import Ejercicio.entity.Pais;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface PaisRepository extends CrudRepository<Pais, Long> {

  /**
   * Encuentra un país dado su nombre
   *
   * @param name
   * @return
   */
  Pais findByName(String name);

  /**
   * Encuentra un país dada su capital
   *
   * @param capital
   * @return
   */
  Pais findByCapital(Capital capital);

  /**
   * Devuelve lista con países con menos habitantes que los pasados como
   * parámetro
   *
   * @param poblacion
   * @return lista de paises
   */
  List<Pais> findByPoblacionLessThan(Long poblacion);

  /**
   * Devuelve lista con países con más habitantes que los pasados como parámetro
   *
   * @param poblacion
   * @return lista de paises
   */
  List<Pais> findByPoblacionGreaterThan(Long poblacion);

  /*
  List<Pais> paisConCapitalConMenosHabitantesQue(Long habitantes);

  List<Pais> paisConCapitalConMasHabitantesQue(Long habitantes);*/
}
