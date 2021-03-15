/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio.service;

import Ejercicio.entity.Capital;
import Ejercicio.entity.Pais;
import Ejercicio.repository.CapitalRepository;
import Ejercicio.repository.PaisRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CapitalServiceImpl implements CapitalService {

  @Autowired
  private CapitalRepository capitalRepository;

  @Autowired
  private PaisRepository paisRepository;

  @Override
  public Optional<Capital> getByID(Long id) {
    return capitalRepository.findById(id);
  }

  @Override
  public List<Capital> getCapitales() {
    return (List<Capital>) capitalRepository.findAll();
  }

  @Override
  public void borraCapital(Long id) {
    capitalRepository.deleteById(id);
  }

  @Override
  public Capital guardaCapital(Capital capital) {
    return capitalRepository.save(capital);
  }

  @Override
  public List<Capital> getCapitalesSinPais() {
    List<Capital> capitales = (List<Capital>) capitalRepository.findAll();
    List<Pais> paises = (List<Pais>) paisRepository.findAll();
    for (Pais pais : paises) {
      for (Capital cap : capitales) {
        if (pais.getCapital().getId() == cap.getId()) {
          capitales.remove(cap);
          break;
        }
      }
    }
    return capitales;
  }

  @Override
  public List<Capital> findByHabitantesLessThan(Long habitantes) {
    return capitalRepository.findByHabitantesLessThan(habitantes);
  }

  @Override
  public List<Capital> findByHabitantesGreaterThan(Long habitantes) {
    return capitalRepository.findByHabitantesGreaterThan(habitantes);
  }
}
