package Ejercicio.repository;

import Ejercicio.entity.Invoice;
import org.springframework.data.repository.CrudRepository;

public interface InvoiceRepository extends CrudRepository<Invoice, Long> {

}
