package Ejercicio.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class Pais {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Size(min = 2, message = "Debe ser mayor que 2 letras")
  private String name;

  @Min(value = 1000, message = "¿Existen países tan pequeños?")
  @Max(value = 2147483647, message = "Lo siento. El valor máximo aceptable por el programa es 2147483647")
  private long poblacion;

  @Size(min = 2, message = "Debe ser mayor que 2 letras")
  private String comida;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "capital_id")
  private Capital capital;

  public Pais() {
  }

  public Pais(long id, String name, long poblacion, String comida, Capital capital) {
    this.id = id;
    this.name = name;
    this.poblacion = poblacion;
    this.comida = comida;
    this.capital = capital;
  }

  @Override
  public String toString() {
    return "Pais{" + "id=" + id + ", name=" + name + ", poblacion=" + poblacion + ", comida=" + comida + ", capital=" + capital + '}';
  }

}
