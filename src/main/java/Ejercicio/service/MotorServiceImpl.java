package Ejercicio.service;

import Ejercicio.entity.Motor;
import Ejercicio.repository.MotorRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MotorServiceImpl implements MotorService {

  @Autowired
  private MotorRepository motorRepository;

  @Override
  public Optional<Motor> getByID(Long id) {
    Optional<Motor> motor = motorRepository.findById(id);
    if (motor.isPresent()) {
      if (motor.get().getCantidadcilindros() == 0) {
        motor.get().setCantidadcilindros(1);
      }
      if (motor.get().getCilindrada() == 0) {
        motor.get().setCilindrada(1);
      }
    }
    return motor;
  }
  
    @Override
  public Optional<Motor> getByIDsoloMostrar(Long id) {
    return motorRepository.findById(id);
  }

  @Override
  public List<Motor> getMotores() {
    return (List<Motor>) motorRepository.findAll();
  }

  @Override
  public void borraMotor(Long id) {
    motorRepository.deleteById(id);
  }

  @Override
  public Motor guardaMotor(Motor motor) {
    if (motor.getCantidadcilindros() == 1) {
      motor.setCantidadcilindros(0);
    }
    if (motor.getCilindrada() == 1) {
      motor.setCilindrada(0);
    }
    return motorRepository.save(motor);
  }

}
