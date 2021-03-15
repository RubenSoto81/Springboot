package Ejercicio.service;

import java.util.List;
import java.util.Optional;
import Ejercicio.entity.Capital;

public interface CapitalService {

  public Optional<Capital> getByID(Long id);

  public List<Capital> getCapitales();

  public void borraCapital(Long id);

  public Capital guardaCapital(Capital capital);

  public List<Capital> getCapitalesSinPais();

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
