package com.tutego.insel.bean.validation;

import javax.validation.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

public class PersonValidator {
  
  public static class Person {
    @NotNull
    @EMail
    public String email; // = "a@b.com";
  }

  public static void main( String[] args ) {
    Validator v = Validation.buildDefaultValidatorFactory().getValidator();
    
    Person p = new Person();

    Set<ConstraintViolation<Person>> constraintViolations = v.validate( p );
    for ( ConstraintViolation<Person> violation : constraintViolations )
      System.out.println( violation.getPropertyPath() + " " + violation.getMessage() );
  }
}