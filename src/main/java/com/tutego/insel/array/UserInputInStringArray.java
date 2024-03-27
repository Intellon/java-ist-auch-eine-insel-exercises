package com.tutego.insel.array;

import java.util.Scanner;

public class UserInputInStringArray {

  @SuppressWarnings( "resource" )
  public static void main( String[] args ) {
    String[] validInputs = { "Banane", "Apfel", "Kirsche" };
  
    boolean found = false;
    while ( ! found ) {
      String input = new Scanner( System.in ).nextLine();
  
      for ( String s : validInputs )
        if ( s.equals( input ) ) {
          found = true;
          break;
        }
    }
  
    System.out.println( "Gültiges Früchtchen eingegeben" );
  }
}