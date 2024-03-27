package com.tutego.insel.sound;

import javax.sound.sampled.*;
import java.io.IOException;
import java.net.URL;

public class AudioSystemClipDemo {
  public static void main( String[] args )
          throws IOException, UnsupportedAudioFileException, LineUnavailableException {

    URL url = new URL( "https://upload.wikimedia.org/wikipedia/commons/9/98/Beepalert.wav" );
    try ( AudioInputStream audioIn = AudioSystem.getAudioInputStream( url ) ) {
      Clip clip = AudioSystem.getClip();
      clip.open( audioIn );
      clip.start();
      while ( clip.getFramePosition() < clip.getFrameLength() )
        Thread.yield();
      System.out.println( url + " abgespielt" );
      }
    }
}