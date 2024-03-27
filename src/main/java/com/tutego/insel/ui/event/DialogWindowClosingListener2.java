package com.tutego.insel.ui.event;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class DialogWindowClosingListener2 extends WindowAdapter {
  @Override public void windowClosing( WindowEvent event ) {
    int option = JOptionPane.showConfirmDialog( null, "Applikation beenden?" );
    if ( option == JOptionPane.OK_OPTION )
      System.exit( 0 );
  }
}