package com.tutego.insel.lambda;
import java.util.Arrays;
import java.util.function.Consumer;
import java.util.logging.Logger;

class Consumers {
  public static <T> Consumer<T> executionTimeLogger( Consumer<T> block ) {
    return t -> {
      long start = System.nanoTime();
      block.accept( t );
      long duration = System.nanoTime() - start;
      Logger.getAnonymousLogger().info( "Ausführungszeit (ns): " + duration );
    };
  }
  
  public static void main( String[] args ) {
    Arrays.asList( 1, 2, 3, 4 ).forEach( executionTimeLogger( System.out::println ) );
  }
}