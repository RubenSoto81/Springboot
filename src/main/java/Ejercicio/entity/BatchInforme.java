package Ejercicio.entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Informe")
public class BatchInforme extends Informes {

  public BatchInforme() {
    super();
  }

  public BatchInforme(Informes inf) {
    super(inf); 
  }
 
}
