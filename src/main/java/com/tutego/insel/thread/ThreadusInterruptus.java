package com.tutego.insel.thread;

class ThreadusInterruptus {
  public static void main( String[] args ) throws InterruptedException {
    Runnable killingMeSoftly = () -> {
      System.out.println( "Es gibt ein Leben vor dem Tod." );
    
      while ( ! Thread.currentThread().isInterrupted() ) {
        System.out.println( "Und er läuft und er läuft und er läuft" );
    
        try {
          Thread.sleep( 500 );
        }
        catch ( InterruptedException e ) {
          Thread.currentThread().interrupt();
          System.out.println( "Unterbrechung in sleep()" );
        }
      } // end while
    
      System.out.println( "Das Ende" );
    };
    
    Thread t = new Thread( killingMeSoftly );
    t.start();
    Thread.sleep( 2000 );
    t.interrupt();
  }
}