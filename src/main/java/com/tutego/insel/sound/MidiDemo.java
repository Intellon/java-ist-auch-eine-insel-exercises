package com.tutego.insel.sound;

import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequencer;
import java.io.InputStream;

public class MidiDemo {

  public static void main( String[] args ) throws Exception {
    String filename = "media/beginn.mid";
    try ( Sequencer sequencer = MidiSystem.getSequencer();
        InputStream midiFile = ClassLoader.getSystemResourceAsStream( filename ) ) {
    
      sequencer.open();
      sequencer.setSequence( MidiSystem.getSequence( midiFile ) );
      sequencer.start();
    
      System.out.println( "Return beendet das Abspielen" );
      System.in.read();
    
      sequencer.stop();
    }
    System.exit( 0 );
  }
}