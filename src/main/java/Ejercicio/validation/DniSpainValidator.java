package Ejercicio.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DniSpainValidator implements ConstraintValidator<DniSpainConstraint, String> {

  @Override
  public void initialize(DniSpainConstraint id) {
  }

  /**
   * es un número con 7 números ( hasta 8888888 ) y 2 letras en mayúsculas
   *
   * @param idField
   * @param cxt
   * @return
   */
  @Override
  public boolean isValid(String idField, ConstraintValidatorContext cxt) {
    return idField != null
            && idField.matches("[0-9]{8}[a-zñA-ZÑ]{1}")
            && letraEsCorrecta(idField);
  }

  private boolean letraEsCorrecta(String idField) {
    String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
    int dni = Integer.parseInt(idField.substring(0, 8));
    String letra = idField.substring(8);

    dni = dni % letras.length();
    String check = letras.substring(dni, dni + 1);

    return letra.equalsIgnoreCase(check);
  }

}
