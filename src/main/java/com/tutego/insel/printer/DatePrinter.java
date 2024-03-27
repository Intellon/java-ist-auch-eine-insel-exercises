package com.tutego.insel.printer;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class DatePrinter {
  public static void printCurrentDate() {
    DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDate( FormatStyle.MEDIUM );
    System.out.println( LocalDate.now().format( formatter ) );
  }
}