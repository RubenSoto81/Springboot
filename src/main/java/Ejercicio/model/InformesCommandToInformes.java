package Ejercicio.model;

import Ejercicio.entity.Informes;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class InformesCommandToInformes implements Converter<InformesCommand, Informes> {

  /**
   * Le mandas un informesCommand y devuelve un Informes
   *
   * @param informesCommand
   * @return Informes
   */
  @Synchronized
  @Nullable
  @Override
  public Informes convert(InformesCommand informesCommand) {
    if (informesCommand == null) {
      return null;
    } 
    Informes informes = new Informes();
    informes.setId(informesCommand.getId());
    informes.setContenido(informesCommand.getContenido());
    informes.setFecha(informesCommand.getFecha());
    informes.setTema(informesCommand.getTema());
    return informes;
  }
}
