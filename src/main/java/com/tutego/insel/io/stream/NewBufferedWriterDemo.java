package com.tutego.insel.io.stream;

import java.io.IOException;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class NewBufferedWriterDemo {

  public static void main( String[] args ) {
    try ( Writer out = Files.newBufferedWriter( Paths.get( "out.bak.txt" ),
                                                StandardCharsets.ISO_8859_1 ) ) {
      out.write( "Zwei Jäger treffen sich..." );
      out.write( System.lineSeparator() );
    }
    catch ( IOException e ) {
      e.printStackTrace();
    }
  }
}