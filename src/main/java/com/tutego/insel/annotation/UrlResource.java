package com.tutego.insel.annotation;

import java.lang.annotation.*;

@Documented
@Target( ElementType.FIELD )
@Retention( RetentionPolicy.RUNTIME )
public @interface UrlResource {

  enum UpperLowerCase { UNCHANGED, LOWERCASE, UPPERCASE }

  String value();

  boolean trim() default false;

  UpperLowerCase upperLowerCase() default UpperLowerCase.UNCHANGED;

  Class<? extends ResourceConverter>[] converter() default { };
}