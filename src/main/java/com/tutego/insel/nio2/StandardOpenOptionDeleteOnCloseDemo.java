package com.tutego.insel.nio2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class StandardOpenOptionDeleteOnCloseDemo {
  public static void main( String[] args ) throws IOException {
    Path path = Paths.get( "opa.herbert.tmp" );
    
    Files.deleteIfExists( path );
    System.out.println( Files.exists( path ) );   // false
    
    Files.newOutputStream( path ).close();
    System.out.println( Files.exists( path ) );   // true
    
    Files.newOutputStream( path, StandardOpenOption.DELETE_ON_CLOSE,
                                 StandardOpenOption.SYNC ).close();
    System.out.println( Files.exists( path ) );   // false
  }
}
