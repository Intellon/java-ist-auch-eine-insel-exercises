package com.tutego.insel.ui.datatransfer;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;

class PrintClipboard {
  public static void main( String[] args ) throws Exception {
    Clipboard systemClipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
    Transferable transferData = systemClipboard.getContents( null );

    for ( DataFlavor dataFlavor : transferData.getTransferDataFlavors() ) {
      Object content = transferData.getTransferData( dataFlavor );

      if ( content instanceof String ) {
        System.out.println( content );
        break;
      }
    }
  }
}
