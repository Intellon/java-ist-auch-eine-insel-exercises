package com.tutego.insel.nio.channels;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FileChannelDemo {
  public static void main( String[] args ) throws IOException {
    Path p = Paths.get( "Kurt Cobain.txt" );
    try ( FileChannel fileChannel =
           (FileChannel) Files.newByteChannel( p, StandardOpenOption.READ ) ) {
      ByteBuffer byteBuffer = fileChannel.map( FileChannel.MapMode.READ_ONLY, 0,
                                               fileChannel.size() );
    
      CharsetDecoder decoder = StandardCharsets.ISO_8859_1.newDecoder();
      CharBuffer charBuffer = decoder.decode( byteBuffer );        
      
      while ( charBuffer.hasRemaining() )
        System.out.print( charBuffer.get() );
    }
  }
}