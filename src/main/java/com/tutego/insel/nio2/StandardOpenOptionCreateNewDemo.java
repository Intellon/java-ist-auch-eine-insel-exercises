package com.tutego.insel.nio2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class StandardOpenOptionCreateNewDemo {
  public static void main( String[] args ) throws IOException {
    Files.deleteIfExists( Paths.get( "opa.herbert.tmp" ) );
    Files.newOutputStream( Paths.get( "opa.herbert.tmp" ) ).close();
    Files.newOutputStream( Paths.get( "opa.herbert.tmp" ) ).close();
    Files.newOutputStream( Paths.get( "opa.herbert.tmp" ), StandardOpenOption.CREATE_NEW ).close();
  }
}