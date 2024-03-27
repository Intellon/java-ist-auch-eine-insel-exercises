package com.tutego.insel.lambda;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

class FileCache {
  private Map<String, byte[]> map = new HashMap<>();

  public byte[] getContent( String filename ) {
    return map.computeIfAbsent( filename, file -> {
      try {
        return Files.readAllBytes( Paths.get( file ) );
      }
      catch ( IOException e ) {
        throw new UncheckedIOException( e );
      }
    } );
  }
}