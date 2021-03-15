package Ejercicio.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class Capital {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Size(min = 2, message = "Debe ser mayor que 2 letras")
  private String nombre;

  @Min(value = 15000, message = "Hacen falta más habitantes para ser capital")
  @Max(value = 2147483647, message = "Lo siento. El valor máximo aceptable por el programa es 2147483647")
  private long habitantes;

  @Override
  public String toString() {
    return "Capital{" + "id=" + id + ", nombre=" + nombre + ", habitantes=" + habitantes + '}';
  }
}
