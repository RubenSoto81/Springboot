package Ejercicio.service;

import java.util.List;
import java.util.Optional;
import Ejercicio.entity.Customer;

public interface CustomerService { 

  public Optional<Customer> getByID(Long id);

  public List<Customer> getCustomers();

  public void borraCustomer(Long id);

  public Customer guardaCustomer(Customer customer);

}
