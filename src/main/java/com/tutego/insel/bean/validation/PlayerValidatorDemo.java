package com.tutego.insel.bean.validation;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;

import java.util.ArrayList;
import java.util.Set;


public class PlayerValidatorDemo {

  public static void main( String[] args ) {
    Player p = new Player();
    
    Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
    
    Set<ConstraintViolation<Player>> constraintViolations = validator.validate( p );

    for ( ConstraintViolation<Player> violation : constraintViolations )
      System.out.println( violation.getPropertyPath() + " " + violation.getMessage() );

    Set<ConstraintViolation<Player>> ageViolation = validator.validateProperty( p, "age" );
    if ( ! ageViolation.isEmpty() )
      System.out.println( new ArrayList<>(ageViolation).get( 0 ).getMessage() );
  }
}