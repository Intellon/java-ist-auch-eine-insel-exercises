package com.tutego.insel.ui.list;

import javax.swing.*;

public class JListAddElementsDemo {
  public static void main( String[] args ) {
    JFrame frame = new JFrame( "Levels of Happiness" );
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    frame.setLayout( new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS) );

    final DefaultListModel<String> listModel = new DefaultListModel<>();

    final JList<String> list = new JList<>( listModel );
    JButton     btn  = new JButton( "Remove" );
    JTextField  tf   = new JTextField();

    frame.add( btn );
    frame.add( new JScrollPane(list) );
    frame.add( tf );

    btn.addActionListener( e -> {
      int index = list.getSelectedIndex();
      if ( index == -1 )
        return;
    
      listModel.remove( index );
    } );

    tf.addActionListener( e -> {
      JTextField textField = (JTextField) e.getSource();
      listModel.addElement( textField.getText() );
      textField.setText( "" );
    } );
    
    frame.pack();
    frame.setVisible( true );
  }
}