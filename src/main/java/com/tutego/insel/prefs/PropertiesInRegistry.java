package com.tutego.insel.prefs;

import java.io.*;
import java.util.Objects;
import java.util.prefs.*;

public class PropertiesInRegistry {
  static Preferences prefs = Preferences.userRoot().node( "/com/tutego/insel" );
  
  static void fillRegistry() {
    System.getProperties().keySet().stream()
                                   .map( Objects::toString )
                                   .filter( key -> key.startsWith( "user." ) )
                                   .filter( key -> ! System.getProperty( key ).isEmpty() )
                                   .forEach( key -> prefs.put( key, System.getProperty( key ) ) );
  }

  static void display() {
    try {
      for ( String key : prefs.keys() )
       System.out.printf( "%s: %s%n", key, prefs.get( key, "---" ) );
    }
    catch ( BackingStoreException e ) {
      System.err.println( "Knoten können nicht ausgelesen werden: " + e );
    }
  }

  static void saveAsXml() {
    ByteArrayOutputStream sos = new ByteArrayOutputStream();

    try {
      prefs.exportNode( sos );
      System.out.print( sos.toString("UTF-8") );
      System.out.printf( "Existiert Knoten? %b%n", prefs.nodeExists( "" ) );
    }
    catch ( IOException | BackingStoreException e ) {
      System.err.println( "Knoten können nicht exportiert werden: " + e );
    }
  }

  static void removeFromRegistry() {
    try {
      prefs.removeNode();
      System.out.printf( "Existiert Knoten? %b%n", prefs.nodeExists( "" ) );
    }
    catch ( BackingStoreException e ) {
      System.err.println( "Knoten können nicht gelöscht werden: " + e );
    }
  }

  static void addListener() {
    NodePreferenceChangeListener listener = new NodePreferenceChangeListener();

    prefs.addNodeChangeListener( listener );
    prefs.addPreferenceChangeListener( listener );
  }

  public static void main( String[] args ) {
    addListener();
    fillRegistry();
    display();
    saveAsXml();
    removeFromRegistry();
  }
}