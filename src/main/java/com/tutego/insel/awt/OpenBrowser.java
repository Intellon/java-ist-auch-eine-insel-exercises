package com.tutego.insel.awt;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class OpenBrowser {
  public static void main( String[] args ) {
    try {
      Desktop.getDesktop().browse( new URI( "http://www.tutego.com/" ) );
      Desktop.getDesktop().open( new File( "S:/Public.Comp.Lang.Java/3d/Java3D.pdf" ) );
    }
    catch ( IOException | URISyntaxException e ) {
      e.printStackTrace();
    }
  }
}
