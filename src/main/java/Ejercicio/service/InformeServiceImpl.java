package Ejercicio.service;

import Ejercicio.entity.Informes;
import Ejercicio.model.InformesCommand;
import Ejercicio.model.InformesCommandToInformes;
import Ejercicio.model.InformesToInformesCommand;
import Ejercicio.repository.InformesRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InformeServiceImpl implements InformeService {
  
  @Autowired
  private InformesRepository informesRepository;
  @Autowired
  private InformesToInformesCommand informesToInformesCommand;
  @Autowired
  private InformesCommandToInformes informesCommandToInformes;

  /**
   * Muestra informe por el ide
   *
   * @param id
   * @return informe
   */
  @Override
  public Optional<Informes> getByID(Long id) {
    return informesRepository.findById(id);
  }

  /**
   * Muestra lista de informes
   *
   * @return Lista de Informes
   */
  @Override
  public List<Informes> getInformes() {
    return (List<Informes>) informesRepository.findAll();
  }

  /**
   * Convierte y guarda un informe
   *
   * @param informesCommand
   * @return informesCommand
   */
  @Override
  public InformesCommand saveInforme(InformesCommand informesCommand) {
    Informes informes = informesCommandToInformes.convert(informesCommand);//Convierte en informe
    Informes informesGuardado = informesRepository.save(informes); // guarda el informe
    return informesToInformesCommand.convert(informesGuardado);  // Lo devuelve como informeCommand
  }
  /**
   * Borra un informe
   * @param id 
   */
  @Override
  public void borrarInforme(Long id) {
    informesRepository.deleteById(id);
  }
  
}
