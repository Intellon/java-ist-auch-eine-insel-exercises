package com.tutego.insel.exception;

import java.nio.file.Paths;
import java.util.Scanner;

class IDontCare {

  @SuppressWarnings( "resource" )
  public static void main( String[] args ) throws Exception {
    Scanner in = new Scanner( Paths.get( "lyrics.txt" ) );
    System.out.println( in.nextLine() );
  }
}
