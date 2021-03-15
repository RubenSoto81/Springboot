package Ejercicio.entity;

import Ejercicio.validation.FechaConstraint;
import Ejercicio.validation.IdMotorConstraint;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.Data;

@Entity
@XmlRootElement(name = "Motor")
@Data
public class Motor {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long idnum;

  @IdMotorConstraint
  private String id;

  @Size(min = 2, message = "Elija una opción")
  private String tipo;

  @Size(min = 2, message = "Elija una opción")
  private String combustible;

  @Min(value = 1, message = "Elija una opción")
  private int potencia;

  //@Min(value = 1, message = "Elija una opción")
  private int cilindrada;

  //@Min(value = 1, message = "Elija una opción")
  private int cantidadcilindros;

  private boolean turbo;

  private boolean intercooler;

  private boolean carburador;

  @FechaConstraint
  private String fechacreacion;

  @Size(min = 30, message = "Debe escribir una descripción de 30 caracteres al menos")
  private String descripcion;

  private int valvulas;

}
