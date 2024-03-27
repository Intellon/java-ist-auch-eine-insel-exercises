package com.tutego.insel.thread.concurrent;

import java.time.LocalTime;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

class Pirate {

  public static void main( String[] arg ) throws Throwable {

    System.setProperty( "java.util.logging.SimpleFormatter.format", "-> %2$s: %5$s %6$s%n");

    String result =
      CompletableFuture.supplyAsync( Pirate::newName )
                       .thenApply( Pirate::swear )
                       .thenCombine( drinkRum(), Pirate::combinePiratAndDrinks )
                       .thenCombine( drinkRum(), Pirate::combinePiratAndDrinks )
                       .exceptionally( e -> "Pirat Guybrush hat den Todesfluch '" +
                                            e.getCause().getMessage() + "' nicht überlebt" )
                       .get();
    System.out.println( result );
    // Pirat Guybrush flucht und trinkt dann 10 Flaschen Rum und trinkt dann 11 Flaschen Rum
    // Pirat Guybrush hat den Todesfluch 'Avada Kedavra' nicht überlebt
  }

  static String newName() {
    Logger.getGlobal().info( Thread.currentThread().getName() );
    return "Pirat Guybrush";
  }

  static String swear( String pirate ) {
    Logger.getGlobal().info( Thread.currentThread().getName() );
    if ( Math.random() < 0.4 )
      throw new IllegalStateException( "Avada Kedavra" );
    return pirate + " flucht";
  }

  static CompletableFuture<Integer> drinkRum() throws InterruptedException {
    Logger.getGlobal().info( Thread.currentThread().getName() );
    TimeUnit.SECONDS.sleep( 1 );
    return CompletableFuture.supplyAsync( () -> LocalTime.now().getSecond() );
  }

  static String combinePiratAndDrinks( String pirat, int bottlesOfRum ) {
    Logger.getGlobal().info( Thread.currentThread().getName() );
    return pirat + " und trinkt dann " + bottlesOfRum + " Flaschen Rum";
  }
}
