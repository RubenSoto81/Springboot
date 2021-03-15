package Ejercicio.entity;

import Ejercicio.validation.DniSpainConstraint;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.Data;

@Entity
@XmlRootElement(name = "Cliente")
public @Data class Clientes {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Size(min = 2, max = 60)
  private String nombre;

  @Size(min = 2, max = 90)
  private String apellido;

  @DniSpainConstraint
  private String dni;

  @Size(min = 2, max = 60)
  private String ciudad;

}
