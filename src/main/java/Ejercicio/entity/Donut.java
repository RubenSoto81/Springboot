package Ejercicio.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Donut {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id_donut;
  private String nombre;
  private String genero;
  private Long edad;
  private Long donuts_comidos;

  @Override
  public String toString() {
    return "[" + nombre + "," + genero + "," + edad + "," + donuts_comidos + ']';
  }

  
  public Long getId_donut() {
    return id_donut;
  }

  public void setId_donut(Long id_donut) {
    this.id_donut = id_donut;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getGenero() {
    return genero;
  }

  public void setGenero(String genero) {
    this.genero = genero;
  }

  public Long getEdad() {
    return edad;
  }

  public void setEdad(Long edad) {
    this.edad = edad;
  }

  public Long getDonuts_comidos() {
    return donuts_comidos;
  }

  public void setDonuts_comidos(Long donuts_comidos) {
    this.donuts_comidos = donuts_comidos;
  }




}
