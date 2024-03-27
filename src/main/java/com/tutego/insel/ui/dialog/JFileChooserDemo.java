package com.tutego.insel.ui.dialog;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;

public class JFileChooserDemo {
  public static void main( String[] args ) {
    JFileChooser fc = new JFileChooser();
    FileFilter filter = new FileNameExtensionFilter( "Textdateien",
                                                     "xml", "txt", "html", "log" );
    fc.setFileFilter( filter );
    
    switch ( fc.showOpenDialog( null ) ) {
      case JFileChooser.APPROVE_OPTION:
        File file = fc.getSelectedFile();
        System.out.println( file.getName() );
        break;
      default:
        System.out.println( "Auswahl abgebrochen" );
    }
    System.exit( 0 );
  }
}