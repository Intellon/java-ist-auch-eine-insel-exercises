package com.tutego.insel.ui.swing;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PopupMenuMouseListener extends MouseAdapter {
  
  private final JPopupMenu popmen;

  public PopupMenuMouseListener( JPopupMenu popmen ) {
    this.popmen = popmen;
  }

  @Override
  public void mouseReleased( MouseEvent me ) {
    if ( me.isPopupTrigger() )
      popmen.show( me.getComponent(), me.getX(), me.getY() );
  }
}
