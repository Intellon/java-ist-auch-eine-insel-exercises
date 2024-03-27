package com.tutego.insel.nio2;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ListAllLines {
  public static void main( String[] args ) throws IOException, URISyntaxException {
    URI uri = ListAllLines.class.getResource( "/lyrics.txt" ).toURI();
    Path path = Paths.get( uri );
    System.out.printf( "Datei '%s' mit Länge %d Byte(s) hat folgende Zeilen:%n",
                       path.getFileName(), Files.size( path ) );
    int lineCnt = 1;
    for ( String line : Files.readAllLines( path, StandardCharsets.UTF_8 ) )
      System.out.println( lineCnt++ + ": " + line );
  }
}