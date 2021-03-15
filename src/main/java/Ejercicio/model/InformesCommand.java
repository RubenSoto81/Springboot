package Ejercicio.model;

import Ejercicio.validation.FechaConstraint;
import javax.validation.constraints.Size;
import lombok.Data;

public @Data
class InformesCommand {

  private Long id;

  @Size(min = 2, max = 60)
  private String tema;

  @Size(min = 10, max = 1000)
  private String contenido;

  @FechaConstraint
  private String fecha;

}
