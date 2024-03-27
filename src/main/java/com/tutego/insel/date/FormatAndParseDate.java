package com.tutego.insel.date;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

public class FormatAndParseDate {

  public static void main( String[] args ) {
    try {
      DateFormat formatter = DateFormat.getDateTimeInstance();
      System.out.println( new Date() );         // Mon Oct 23 19:58:12 CEST 2017
      String s = formatter.format( new Date() );
      System.out.println( formatter.parse(s) ); // Mon Oct 23 19:58:12 CEST 2017
    }
    catch ( ParseException e ) { e.printStackTrace(); }
  }
}
