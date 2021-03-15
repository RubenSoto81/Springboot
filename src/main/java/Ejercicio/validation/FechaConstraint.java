
package Ejercicio.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;


@Documented
@Constraint(validatedBy = FechaValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface FechaConstraint {

	 String message() default "El formato es DD/MM/AAAA";  //Mensaje que saldrá si NO se valida
	 Class<?>[] groups() default {};
	 Class<? extends Payload>[] payload() default {};
	
}