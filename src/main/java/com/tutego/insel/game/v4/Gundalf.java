package com.tutego.insel.game.v4;

class Gundalf {

  public static void main( String[] args ) {
    Wizard gundalf = new Wizard().name( "Gundalf" ).age( 60 );
    System.out.println( gundalf.name() );         // Gundalf
    System.out.println( gundalf.format() );       // Gundalf ist 60
  }
}
