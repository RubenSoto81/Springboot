package Ejercicio.service;

import java.util.List;
import java.util.Optional;
import Ejercicio.entity.Motor;

public interface MotorService {

  public Optional<Motor> getByID(Long id);

  public List<Motor> getMotores();

  public void borraMotor(Long id);

  public Motor guardaMotor(Motor motor);

  public Optional<Motor> getByIDsoloMostrar(Long id);

}
