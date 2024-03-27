package com.tutego.insel.net;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.math.BigInteger;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class MulServer {

  public static void main( String[] args ) throws IOException {
    try ( ServerSocket server = new ServerSocket( 3141 ) ) {
      while ( true )
        try ( Socket client = server.accept() ) {
          handleConnection( client );
        }
        catch ( IOException e ) {
          e.printStackTrace();
        }
    }
  }
  
  private static void handleConnection( Socket client ) throws IOException {
    try ( Scanner in = new Scanner( client.getInputStream(), "UTF-8" );
          Writer osw = new OutputStreamWriter( client.getOutputStream(), "UTF-8" );
          PrintWriter out = new PrintWriter( osw, true ) ) {
      String factor1 = in.nextLine();
      String factor2 = in.nextLine();
      out.println( new BigInteger( factor1 ).multiply( new BigInteger( factor2 ) ) );
    }
  }
}