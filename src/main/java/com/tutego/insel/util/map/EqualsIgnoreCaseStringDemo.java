package com.tutego.insel.util.map;

import java.util.HashMap;
import java.util.Map;

import static java.lang.System.out;

public class EqualsIgnoreCaseStringDemo {
  public static void main( String[] args ) {
    Map<EqualsIgnoreCaseString, String> map = new HashMap<>();
    out.println( map.put( new EqualsIgnoreCaseString("tutego"), "tutego" ) ); // null
    out.println( map.put( new EqualsIgnoreCaseString("Tutego"), "Tutego" ) ); // tutego
    out.println( map.put( new EqualsIgnoreCaseString("TUTI!"), "TUTI!" ) );   // null
    
    out.println( map.get( new EqualsIgnoreCaseString("tutego") ) );           // Tutego
    out.println( map.get( new EqualsIgnoreCaseString("TUTEGO") ) );           // Tutego
    out.println( map.get( new EqualsIgnoreCaseString("tUtI!") ) );            // TUTI!
    out.println( map.get( new EqualsIgnoreCaseString("tr�t") ) );             // null
  }
}
