package com.tutego.insel.io;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.CRC32;
import java.util.zip.CheckedInputStream;

class CRC32Demo {
  private static final int EOF = -1;

  static public void main( String[] args ) {
    CRC32 crc = new CRC32();
    try ( InputStream in = CRC32Demo.class.getResourceAsStream( "/lyrics.txt" );
          InputStream cis = new CheckedInputStream( in, crc );
          InputStream bis = new BufferedInputStream( cis ) ) {
      while ( cis.read() != EOF ) { /* Bis zum Ende */ }
    
      System.out.printf( "%08X", crc.getValue() ); // F9A39CFC
    }
    catch ( IOException e ) {
      e.printStackTrace();
    }
  }
}