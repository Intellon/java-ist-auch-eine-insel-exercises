package com.tutego.insel.game.vi;

import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Game {

  public static void main( String[] args ) {

    HashMap<String, GameObject> gameObjects = new HashMap<>();
    
    GameObject nullGameObject = new GameObject() {
      @Override public boolean useOn( GameObject object ) { return false; }
    };

    gameObjects.put( "höllentor", new Door( 1 ) );
    gameObjects.put( "höllenschlüssel", new Key( 1 ) );
    gameObjects.put( "himmelsschlüssel", new Key( 9 ) );
    
    while ( true ) {
      System.out.printf( "Was möchtest du tun?%n> " );
      @SuppressWarnings( "resource" )
      String input = new Scanner( System.in ).nextLine().toLowerCase();
      if ( input.matches( "ende|bye|schluss|quit" ) )
        System.exit( 0 );
      String simplifiedLine = input.replaceAll( "benutze|stecke|nutze|mit|bei|auf|unter|in", "" );
      StringTokenizer tokenizer = new StringTokenizer( simplifiedLine );
      if ( tokenizer.countTokens() < 2 ) {
        System.out.println( "Details bitte, '" + input + "' reicht mir nicht!" );
        continue;
      }
      GameObject subject = gameObjects.getOrDefault( tokenizer.nextToken(), nullGameObject );
      GameObject object = gameObjects.getOrDefault( tokenizer.nextToken(), nullGameObject );
      System.out.println( subject.useOn( object ) ? "Ausgeführt"
                                                  : "Konnte '" + input + "' nicht ausführen" );
    }
  }
}
