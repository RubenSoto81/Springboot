package Ejercicio.repository;

import Ejercicio.entity.Clientes;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface ClientesRepository extends CrudRepository<Clientes, Long> {

  List<Clientes> findByNombreContaining(String nombre);

  List<Clientes> findByApellidoContaining(String apellido);

  List<Clientes> findByCiudadContaining(String ciudad);

  List<Clientes> findByIdGreaterThanEqualOrderByApellido(Long id);

}
