package com.tutego.insel.oop;
class StaticBlock {

  static {
    System.out.print( "Gut, dass " );
  }

  public static void main( String[] args ) {
    System.out.println( "zum Nachbarn hat." );
  }

  static {
    System.out.print( "Neuer Boateng " );
  }
}
