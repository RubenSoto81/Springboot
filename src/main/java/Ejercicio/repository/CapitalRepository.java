package Ejercicio.repository;

import Ejercicio.entity.Capital;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface CapitalRepository extends CrudRepository<Capital, Long> {

  /**
   * Devuelve lista con capitales con menos habitantes que los pasados como
   * parámetro
   *
   * @param habitantes
   * @return Lista de capitales
   */
  List<Capital> findByHabitantesLessThan(Long habitantes);

  /**
   * Devuelve lista con capitales con menos habitantes que los pasados como
   * parámetro
   *
   * @param habitantes
   * @return Lista de capitales
   */
  List<Capital> findByHabitantesGreaterThan(Long habitantes);
}
