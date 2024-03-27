package com.tutego.insel.ui.event;

import javax.swing.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class DialogWindowClosingListener implements WindowListener {
  @Override public void windowClosing( WindowEvent event ) {
    int option = JOptionPane.showConfirmDialog( null, "Applikation beenden?" );
    if ( option == JOptionPane.OK_OPTION )
      System.exit( 0 );
  }

  @Override public void windowClosed( WindowEvent event ) { /*Empty*/ }
  @Override public void windowDeiconified( WindowEvent event ) { /*Empty*/ }
  @Override public void windowIconified( WindowEvent event ) { /*Empty*/ }
  @Override public void windowActivated( WindowEvent event ) { /*Empty*/ }
  @Override public void windowDeactivated( WindowEvent event ) { /*Empty*/ }
  @Override public void windowOpened( WindowEvent event ) { /*Empty*/ }
}