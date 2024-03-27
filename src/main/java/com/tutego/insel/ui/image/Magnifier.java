package com.tutego.insel.ui.image;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Magnifier {
  public static void main( String[] args ) {
    final ImageIcon icon = new ImageIcon();
    final JLabel label = new JLabel( icon );
    
    new Timer( 100 /* ms */, e -> {
      try {
        Rectangle location = new Rectangle( MouseInfo.getPointerInfo().getLocation(),
                                            new Dimension( 40, 40 ) );
        location.translate( -20, -20 );
        BufferedImage img = new Robot().createScreenCapture( location );
        icon.setImage( img.getScaledInstance( img.getWidth() * 8, img.getHeight() * 8,
                                              Image.SCALE_FAST ) );
        label.repaint();
      }
      catch ( AWTException ae ) { }
    } ).start();
    
    JOptionPane.showMessageDialog( null, label );
  }
}
