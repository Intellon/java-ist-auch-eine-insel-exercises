package com.tutego.insel.nested;

import java.util.Timer;
import java.util.TimerTask;

public class SportReminder {
  public static void main( String[] args ) {
    class SportReminderTask extends TimerTask {
      @Override public void run() {
        System.out.println( "Los, beweg dich, du faule Wurst!" );
      }
    }
    new Timer().scheduleAtFixedRate( new SportReminderTask(), 0 /* ms delay */,
                                     1000 /* ms period */ );
  }
}