package Ejercicio.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;

@Entity
public class Invoice {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Min(value = 0, message = "Las facturas deben ser números positivos")
  private double amount;

  private boolean processed;

 /* @Min(value = 1, message = "Los customers se cuentan a partir de 1")*/
  private Long customer_id;

  public Invoice() {
  }

  public Invoice(double amount, boolean processed, Long customer_id) {
    this.amount = amount;
    this.processed = processed;
    this.customer_id = customer_id;
  }

  public Invoice(Long id, double amount, boolean processed, Long customer_id) {
    this.id = id;
    this.amount = amount;
    this.processed = processed;
    this.customer_id = customer_id;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public double getAmount() {
    return amount;
  }

  public void setAmount(double amount) {
    this.amount = amount;
  }

  public boolean getProcessed() {
    return processed;
  }

  public void setProcessed(boolean processed) {
    this.processed = processed;
  }

  public Long getCustomer_id() {
    return customer_id;
  }

  public void setCustomer_id(Long customer_id) {
    this.customer_id = customer_id;
  }

  @Override
  public String toString() {
    return "Invoice{" + "id=" + id + ", amount=" + amount + ", processed=" + processed + ", customer_id=" + customer_id + '}';
  }

}
