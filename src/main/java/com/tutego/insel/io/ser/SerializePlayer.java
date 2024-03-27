package com.tutego.insel.io.ser;

import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SerializePlayer {
  public static void main( String[] args ) throws Exception {
    try ( OutputStream fos = Files.newOutputStream( Paths.get( "player.ser" ) );
          ObjectOutputStream oos = new ObjectOutputStream( fos ) ) {
      oos.writeObject( new Player() );
    }
  }
}