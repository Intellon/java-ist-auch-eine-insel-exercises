package com.tutego.insel.ui.swing;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class ImageIconDemo {
  public static void main( String[] args ) {
    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    frame.setLayout( new FlowLayout() );

    URL resource1 = ImageIconDemo.class.getResource( "/images/user-trash-full.png" );
    URL resource2 = ImageIconDemo.class.getResource( "/images/user-trash.png" );
    Icon icon1 = new ImageIcon( resource1 );
    Icon icon2 = new ImageIcon( resource2 );

    JButton button = new JButton();
    button.setIcon( icon1 );
    frame.add( button );
    frame.add( new JLabel( icon2 ) );

    frame.pack();
    frame.setVisible( true );
  }
}