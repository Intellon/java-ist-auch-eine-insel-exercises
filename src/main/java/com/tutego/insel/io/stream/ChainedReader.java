package com.tutego.insel.io.stream;

import java.io.*;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

import static java.nio.charset.StandardCharsets.ISO_8859_1;

public class ChainedReader {
  public static void main( String[] args ) throws NoSuchAlgorithmException {
    MessageDigest digest = MessageDigest.getInstance("SHA-256");
    try ( InputStream       fis = Files.newInputStream( Paths.get( "lyrics.txt" ) );
          InputStream       bis = new BufferedInputStream( fis );
          DigestInputStream dis = new DigestInputStream( bis, digest );
          Reader            isr = new InputStreamReader( dis, ISO_8859_1 );
          Scanner scanner = new Scanner( isr ) ) {
      while ( scanner.hasNextLine() )
        System.out.println( scanner.nextLine() );
      System.out.printf( "%X", new BigInteger( 1, dis.getMessageDigest().digest() ) );
    }
    catch ( IOException e ) {
      System.err.println( "Konnte Datei nicht einlesen" );
      e.printStackTrace();
    }
  }
}