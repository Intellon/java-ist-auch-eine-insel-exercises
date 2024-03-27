package com.tutego.insel.ui.event;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ClickOnJLabelToClose {
  public static void main( String[] args ) {
    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

    JLabel label = new JLabel( "Lebe immer First-Class, sonst tun es deine Erben!" );
    label.setForeground( Color.BLUE );

    frame.add( label );

    label.addMouseListener( new MouseAdapter() {
      @Override public void mouseClicked( MouseEvent e ) {
        if ( e.getClickCount() > 1 )
          System.exit( 0 );
      }
    } );

    frame.pack();
    frame.setVisible( true );
  }
}