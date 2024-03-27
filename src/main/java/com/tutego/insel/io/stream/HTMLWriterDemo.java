package com.tutego.insel.io.stream;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

public class HTMLWriterDemo {
  public static void main( String[] args ) throws IOException {
    StringWriter sw = new StringWriter();
    try ( HTMLWriter html = new HTMLWriter( sw, "Superkreativer Titel" );
          PrintWriter pw = new PrintWriter( html ) ) {
      pw.println( "Und eine Menge von Sonderzeichen: < und > und &" );
      pw.println( "Zweite Zeile" );
      pw.println();
      pw.println( "Leerzeile" );
      pw.println( "Keine Leerzeile danach" );
    }
    System.out.println( sw );
  }
}
