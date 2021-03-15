package Ejercicio.model;

import org.springframework.core.convert.converter.Converter;
import Ejercicio.entity.Informes;
import org.springframework.stereotype.Component;

@Component
public class InformesToInformesCommand implements Converter<Informes, InformesCommand> {

  /**
   * Le das un Informe y te devuelve un informe
   *
   * @param informes
   * @return
   */
  @Override
  public InformesCommand convert(Informes informes) {
    if (informes == null) {
      return null;
    }
    InformesCommand informesCommand = new InformesCommand();
    informesCommand.setId(informes.getId());
    informesCommand.setContenido(informes.getContenido());
    informesCommand.setFecha(informes.getFecha());
    informesCommand.setTema(informes.getTema());
    return informesCommand;
  }
}
