package Ejercicio.service;

import java.util.List;
import java.util.Optional;
import Ejercicio.entity.Invoice;

public interface InvoiceService {

  public Optional<Invoice> getByID(Long id);

  public List<Invoice> getInvoices();

  public void borraInvoice(Long id);

  public Invoice guardaInvoice(Invoice invoice);

}
