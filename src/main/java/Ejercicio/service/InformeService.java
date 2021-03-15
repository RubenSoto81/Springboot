package Ejercicio.service;

import java.util.List;
import java.util.Optional;
import Ejercicio.entity.Informes;
import Ejercicio.model.InformesCommand;


public interface InformeService {

  public Optional<Informes> getByID(Long id);  // muestra Informe por ID
  public List<Informes> getInformes();  // muestra lista de Informes
  public void borrarInforme(Long id);
  public InformesCommand saveInforme(InformesCommand informesCommand);  // convierte y guarda Informe

}
