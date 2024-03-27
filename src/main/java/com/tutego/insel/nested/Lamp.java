package com.tutego.insel.nested;

public class Lamp {

  static String name = "Latifa";
  int watt = 1985;

  static class Bulb {
    void output() {
      System.out.println( name );
//      System.out.println( watt );   // Cannot make a static reference to the non-static field watt
    }
  }

  public static void main( String[] args ) {
    Bulb bulp = new Lamp.Bulb();  // or Lamp.Bulb bulp = ...
    bulp.output();
  }
}