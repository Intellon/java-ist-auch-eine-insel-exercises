package com.tutego.insel.ui.print;

import java.awt.*;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

public class PrintStuff {
  public static void main( String[] args ) throws PrinterException {
    PrinterJob pjob = PrinterJob.getPrinterJob();

    if ( ! pjob.printDialog() )
      return;

    pjob.setPrintable( new TextPrintable() );
    pjob.print();
  }

  static class TextPrintable implements Printable {
    static Font FONT = new Font( Font.SANS_SERIF, Font.PLAIN, 20 );

    @Override
    public int print( Graphics g, PageFormat pageFormat, int pageIndex ) {
      if ( pageIndex >= 2 )
        return Printable.NO_SUCH_PAGE;

      g.setFont( FONT );
      g.drawString( "Hallo auf Seite " + pageIndex, 100, 100 );

      return Printable.PAGE_EXISTS;
    }
  }
}