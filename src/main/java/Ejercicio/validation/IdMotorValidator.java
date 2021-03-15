package Ejercicio.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class IdMotorValidator implements ConstraintValidator<IdMotorConstraint, String> {

  @Override
  public void initialize(IdMotorConstraint id) {
  }

  /**
   * El formato es AAA-26-CC-4859
   *
   * @param idField
   * @param cxt
   * @return
   */
  @Override
  public boolean isValid(String idField, ConstraintValidatorContext cxt) {
    return idField != null
            && idField.matches("[a-zñA-ZÑ]{3}-[0-9]{2}-[a-zñA-ZÑ]{2}-[0-9]{4}");
  }
}
