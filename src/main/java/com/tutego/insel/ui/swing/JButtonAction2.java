package com.tutego.insel.ui.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class JButtonAction2 {
  public static void main( String[] args ) {
    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    frame.setLayout( new FlowLayout() );

    frame.add( new JButton( new ExitAction() ) );

    frame.pack();
    frame.setVisible( true );
  }
}

class ExitAction extends AbstractAction {

  {
    putValue( Action.NAME, "Beenden" );
    putValue( Action.DISPLAYED_MNEMONIC_INDEX_KEY, 0 );
  }

  @Override public void actionPerformed( ActionEvent e ) {
    System.exit( 0 );
  }
}
