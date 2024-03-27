package com.tutego.insel.bean.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Constraint( validatedBy = EMailValidator.class )
@Target({ METHOD, FIELD, ANNOTATION_TYPE })
@Retention( RUNTIME )
@Documented
public @interface EMail {
  String message() default "ist keine gültige E-Mail Adresse";
  Class<?>[] groups() default {};
  Class<? extends Payload>[] payload() default {};
}
