package com.tutego.insel.nio2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.DosFileAttributes;

public class SetDosAttribute {
  public static void main( String[] args ) throws IOException {
    Path p = Paths.get( "src/main/resources/lyrics.txt" );    
    System.out.println( Files.readAttributes( p, DosFileAttributes.class ).isArchive() ); // true
    Files.setAttribute( p, "dos:archive", false );
    System.out.println( Files.readAttributes( p, DosFileAttributes.class ).isArchive() ); // false
    Files.setAttribute( p, "dos:archive", true );
    System.out.println( Files.readAttributes( p, DosFileAttributes.class ).isArchive() ); // true
  }
}