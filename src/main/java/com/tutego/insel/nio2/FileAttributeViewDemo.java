package com.tutego.insel.nio2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.DosFileAttributeView;

public class FileAttributeViewDemo {
  public static void main( String[] args ) throws IOException {
    Path p = Paths.get( "src/main/resources/lyrics.txt" );
    DosFileAttributeView fileAttributeView = Files.getFileAttributeView( p, DosFileAttributeView.class );
    System.out.println( fileAttributeView.readAttributes().isArchive() );  // true
    fileAttributeView.setArchive( false );
    System.out.println( fileAttributeView.readAttributes().isArchive() );  // false
    fileAttributeView.setArchive( true );
    System.out.println( fileAttributeView.readAttributes().isArchive() );  // true
  }
}