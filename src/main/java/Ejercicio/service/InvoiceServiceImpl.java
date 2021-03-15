/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio.service;

import Ejercicio.entity.Invoice;
import Ejercicio.repository.InvoiceRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InvoiceServiceImpl implements InvoiceService {

  @Autowired
  private InvoiceRepository invoiceRepository;

  @Override
  public Optional<Invoice> getByID(Long id) {
    return invoiceRepository.findById(id);
  }

  @Override
  public List<Invoice> getInvoices() {
    return (List<Invoice>) invoiceRepository.findAll();
  }

  @Override
  public void borraInvoice(Long id) {
    invoiceRepository.deleteById(id);
  }

  @Override
  public Invoice guardaInvoice(Invoice invoice) {
    return invoiceRepository.save(invoice);
  }

}
