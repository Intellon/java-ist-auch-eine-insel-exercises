package com.tutego.insel.net;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.Socket;
import java.util.Scanner;

class MulClient {

  private static String multipy( String factor1, String factor2 ) throws IOException {
    try ( Socket socket = new Socket( "localhost", 3141 );
          Scanner in = new Scanner( socket.getInputStream(), "UTF-8" );
          Writer osw =  new OutputStreamWriter( socket.getOutputStream(), "UTF-8" );
          PrintWriter out = new PrintWriter( osw, true ) ) {
      out.println( factor1 );
      out.println( factor2 );
      return in.nextLine();
    }
  }

  public static void main( String[] args ) throws IOException {
    System.out.println( multipy( "2", "4" ) );
    System.out.println( multipy( "23895737895", "434589358935857" ) );
  }
}