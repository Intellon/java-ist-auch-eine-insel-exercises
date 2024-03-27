package com.tutego.insel.game.vd;

public class AskForNameOfGameObject {

  public static void printQuestion( GameObject go ) {
    System.out.println( "Woher kommt " + go.name + "?" );
  }
  
  public static void main( String[] args ) {
    Player player = new Player();
    player.name = "Godman";
    printQuestion( player );            // Woher kommt Godman?
  
    GameObject room = new Room();
    room.name = "Hogwurz";
    printQuestion( room );             // Woher kommt Hogwurz?
  }
}
