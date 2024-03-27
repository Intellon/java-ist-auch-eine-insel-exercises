package com.tutego.insel.lambda;

import java.util.Timer;
import java.util.TimerTask;

class TimerTaskLambda {
  public static TimerTask createTimerTask( Runnable runnable ) {
    return new TimerTask() {
      @Override public void run() {
        runnable.run();
      }
    };
  }

  public static void main( String[] args ) {
    new Timer().schedule( createTimerTask( ( ) -> System.out.println( "Hi" ) ), 500 );
  }
}