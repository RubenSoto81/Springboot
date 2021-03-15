package Ejercicio.validation;

import java.time.DateTimeException;
import java.time.LocalDate;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class FechaValidator implements ConstraintValidator<FechaConstraint, String> {

  @Override
  public void initialize(FechaConstraint id) {
  }

  /**
   * El formato es DD/MM/AAAA
   *
   * @param idField
   * @param cxt
   * @return
   */
  @Override
  public boolean isValid(String idField, ConstraintValidatorContext cxt) {
    return idField != null
            && idField.matches("[0-9]{2}/[0-9]{2}/[0-9]{4}")
            && fechaValida(idField);
  }

  public boolean fechaValida(String idField) {
    int dia = Integer.parseInt(idField.substring(0, 2));
    int mes = Integer.parseInt(idField.substring(3, 5));
    int ano = Integer.parseInt(idField.substring(6));
    try {
      LocalDate.of(ano, mes, dia);
    } catch (DateTimeException e) {
      System.out.println("La fecha no existe: " + e.getMessage());
      return false;
    }
    return true;
  }
}
