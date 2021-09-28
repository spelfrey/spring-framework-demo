package com.stevo.demo.validation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import javax.validation.Constraint;

@Constraint(validatedBy = UniqueEmailValidator.class)
@Documented
@Retention(RUNTIME)
@Target(FIELD)
public @interface UniqueEmail {
  String message() default "{duplicateEmail}";

  Class[] groups() default {};

  Class[] payload() default {};
}
