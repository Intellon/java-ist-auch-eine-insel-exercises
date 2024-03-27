package com.tutego.insel.io.stream;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class WriteTinyPPM {
  public static void main( String[] args ) {
    try ( OutputStream out = Files.newOutputStream( Paths.get( "littlepic.tmp.ppm" ) ) ) {
      out.write( "P3 1 1 255 255 0 0".getBytes( StandardCharsets.ISO_8859_1 ) );
    }
    catch ( IOException e ) {
      e.printStackTrace();
    }
  }
}