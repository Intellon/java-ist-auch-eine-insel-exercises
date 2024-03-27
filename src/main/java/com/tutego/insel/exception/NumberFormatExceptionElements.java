package com.tutego.insel.exception;

public class NumberFormatExceptionElements {

  public static void main( String[] args ) {
    try {
      Integer.parseInt( "19%" );
    }
    catch ( NumberFormatException e ) {
      String name = e.getClass().getName(); 
      String msg  = e.getMessage();
      String s    = e.toString();
    
      System.out.println( name ); // java.lang.NumberFormatException
      System.out.println( msg );  // For input string: "19%"
      System.out.println( s );    // java.lang.NumberFormatException: For input string: "19%"
    
      e.printStackTrace();
    }
  }
}