package Ejercicio.repository;

import Ejercicio.entity.Donut;
import org.springframework.data.repository.CrudRepository;

public interface DonutRepository extends CrudRepository<Donut, Long> {
  
  
}
