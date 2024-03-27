package com.tutego.insel.nio2;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ListAllImages {
  public static void main( String[] args ) throws IOException {
    String userHomeDir = System.getProperty( "user.home" );
    Path picturePath = Paths.get( userHomeDir, "Pictures" );

    try ( DirectoryStream<Path> files = Files.newDirectoryStream( picturePath,
                                                                  "*.{gif,jpg,png}" ) ) {
      for ( Path path : files )
        System.out.println( path.getFileName() );
    }
  }
}