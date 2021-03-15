package Ejercicio.entity;

import Ejercicio.validation.DniSpainConstraint;
import java.util.ArrayList;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class Customer {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Size(min = 2, message = "Debe ser mayor que 2 letras")
  private String name;

  @DniSpainConstraint
  private String dni;

  @Size(min = 4, message = "Debe ser mayor que 4 caracteres")
  private String account;

  @OneToMany
  @JoinColumn(name = "customer_id")
  private List<Invoice> invoices = new ArrayList<Invoice>();

  public Customer() {
  }

  public Customer(long id, String name, String dni, String account) {
    this.id = id;
    this.name = name;
    this.dni = dni;
    this.account = account;
  }

  public Customer(String name, String dni, String account) {
    this.name = name;
    this.dni = dni;
    this.account = account;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDni() {
    return dni;
  }

  public void setDni(String dni) {
    this.dni = dni;
  }

  public String getAccount() {
    return account;
  }

  public void setAccount(String account) {
    this.account = account;
  }

  @Override
  public String toString() {
    return "Customer{" + "id=" + id + ", name=" + name + ", dni=" + dni + ", account=" + account + '}';
  }

  public List<Invoice> getInvoices() {
    return invoices;
  }

  public void setInvoices(List<Invoice> invoices) {
    this.invoices = invoices;
  }
}
