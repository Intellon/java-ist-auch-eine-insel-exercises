package com.tutego.insel.exception;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TryWithResourcesReadsLine {

  static String readFirstLine( String file ) {
    try ( BufferedReader br = Files.newBufferedReader( Paths.get( file ),
                                                       StandardCharsets.ISO_8859_1 ) ) {
      return br.readLine();
    }
    catch ( IOException e ) { e.printStackTrace(); return null; }
  }
}