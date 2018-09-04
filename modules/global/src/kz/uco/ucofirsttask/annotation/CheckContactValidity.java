package kz.uco.ucofirsttask.annotation;

import kz.uco.ucofirsttask.entity.Contact;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ ElementType.TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = TaskFeasibilityValidator.class)
public @interface CheckContactValidity {

    String message() default "Invalid contact format!";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
