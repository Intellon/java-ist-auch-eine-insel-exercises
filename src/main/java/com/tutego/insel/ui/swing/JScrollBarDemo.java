package com.tutego.insel.ui.swing;

import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class JScrollBarDemo {
  public static void main( String[] args ) {
    JFrame f = new JFrame();
    f.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    
    f.setLayout( new GridLayout( 2, 1 ) );
    
    JScrollBar sb = new JScrollBar( Adjustable.HORIZONTAL, 50, 10, 0, 100 + 10 );
    JTextField tf = new JTextField( "" + sb.getValue(), 20 );
    tf.addActionListener( e -> sb.setValue( new Scanner(tf.getText()).nextInt() ) );
    sb.addAdjustmentListener( e -> tf.setText( "" + sb.getValue() ) );

    f.add( tf );
    f.add( sb );
    f.pack();
    f.setVisible( true );
  }
}
