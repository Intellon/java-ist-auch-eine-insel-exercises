package com.tutego.insel.lang.ref;

import java.awt.*;
import java.lang.ref.Cleaner;

public class CleanerDemo {
  public static void main( String[] args ) {

    Point p = new Point( 1, 2 );
    Cleaner.create().register( p, () -> System.out.println( "Punkt ist weg!" ) );
    p = null;
    
    @SuppressWarnings( "unused" )
    byte[] bytes = new byte[ (int) Runtime.getRuntime().freeMemory() ];
  }
}
