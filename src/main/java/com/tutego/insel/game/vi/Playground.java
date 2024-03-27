package com.tutego.insel.game.vi;

class Playground {

  public static void main( String[] args ) {
    Door door1 = new Door( 1 );
    GameObject key1 = new Key( 1 );
    GameObject key9 = new Key( 9 );
    
    System.out.printf( "erfolgreich=%b, isOpen=%b%n", key9.useOn(door1), door1.isOpen );
    System.out.printf( "erfolgreich=%b, isOpen=%b%n", key1.useOn(door1), door1.isOpen );
    System.out.printf( "erfolgreich=%b%n", door1.useOn(key1) );
  }
}