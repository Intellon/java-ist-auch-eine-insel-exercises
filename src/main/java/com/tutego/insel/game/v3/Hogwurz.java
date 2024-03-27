package com.tutego.insel.game.v3;

class Hogwurz {

  public static void main( String[] args ) {
    Player parry = new Player();
    parry.name = "Parry Hotter";
    System.out.println( parry.doesCarryAnything() );
    parry.carry( "Denkarium" );
    parry.carry( "Stein der Doofen" );
    System.out.printf( "%s trägt: %s%n", parry.name, parry.item ); 
    System.out.println( parry.doesCarryAnything() );
    parry.dropAll();
    System.out.println( parry.doesCarryAnything() );
    parry.carry( "Das goldene Ei" );
    System.out.printf( "%s trägt: %s%n", parry.name, parry.item ); 
  }
}