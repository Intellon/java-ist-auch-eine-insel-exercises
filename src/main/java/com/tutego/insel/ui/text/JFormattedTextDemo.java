package com.tutego.insel.ui.text;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

public class JFormattedTextDemo {
  public static void main( String[] args ) {
    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    frame.setLayout( new GridLayout(0,1) );
    
    ActionListener actionListener = new ActionListener() {
      @Override public void actionPerformed( ActionEvent e ) {
        System.out.println( ((JFormattedTextField)e.getSource()).getText() );
    } };
    
    JTextField textField1 = new JFormattedTextField(
        new SimpleDateFormat("MM/dd/yy") );
    frame.add( textField1 );
    textField1.addActionListener( actionListener );
    
    JTextField textField2 = new JFormattedTextField(
        new DecimalFormat("#,###") );
    frame.add( textField2 );
    textField2.addActionListener( actionListener );

    frame.pack();
    frame.setVisible( true );
  }
}