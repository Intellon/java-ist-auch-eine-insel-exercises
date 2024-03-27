package com.tutego.insel.exception;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;

public class LogCurrentDateTime2 {
  public static void logExecutedProgram() throws IOException {
    String content = System.getProperty( "sun.java.command" ) + " started at "
                   + LocalDateTime.now() + "\n";
    Files.writeString( Path.of( "executed_programs.txt" ),
                       content, StandardOpenOption.APPEND );
  }
  
  public static void main( String[] args ) {
    try {
      logExecutedProgram();
    }
    catch ( IOException e ) {
      e.printStackTrace();
    }
  }
}
