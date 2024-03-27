package com.tutego.insel.nio2;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Dir {
  public static void main( String[] args ) throws IOException {
    try ( DirectoryStream<Path> files = Files.newDirectoryStream( Paths.get( "c:/" ) ) ) {
      for ( Path path : files )
        System.out.println( path.getFileName() );
    }
  }
}