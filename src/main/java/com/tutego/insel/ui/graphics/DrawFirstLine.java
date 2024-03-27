package com.tutego.insel.ui.graphics;

import javax.swing.*;
import java.awt.*;

class DrawPanel extends JPanel {

  private static final long serialVersionUID = 1L;

  @Override protected void paintComponent( Graphics g ) {
    super.paintComponent( g );

    g.drawLine( 10, 10, 100, 50 );
  }
}

public class DrawFirstLine {
  public static void main( String[] args ) {
    JFrame f = new JFrame();
    f.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    f.setSize( 1000, 1000 );
    f.add( new DrawPanel() );
    f.setVisible( true );
  }
}