package Ejercicio.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.xml.bind.annotation.XmlRootElement;
import lombok.Data;

@Entity
@Data
public class Informes {

  public Informes() {
  }

  public Informes(Informes inf) {
    this.id = inf.id;
    this.tema = inf.tema;
    this.contenido = inf.contenido;
    this.fecha = inf.fecha;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String tema;

  private String contenido;

  private String fecha;

}
