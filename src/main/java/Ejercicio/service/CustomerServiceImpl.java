package Ejercicio.service;

import Ejercicio.entity.Customer;
import Ejercicio.repository.CustomerRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

  @Autowired
  private CustomerRepository customerRepository;

  @Override
  public Optional<Customer> getByID(Long id) {
    return customerRepository.findById(id);
  }

  @Override
  public List<Customer> getCustomers() {
    return (List<Customer>) customerRepository.findAll();
  }

  @Override
  public void borraCustomer(Long id) {
    customerRepository.deleteById(id);
  }

  @Override
  public Customer guardaCustomer(Customer customer) {
    return customerRepository.save(customer);
  }

}
