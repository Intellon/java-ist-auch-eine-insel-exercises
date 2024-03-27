package com.tutego.insel.thread.concurrent;

import java.util.List;
import java.util.concurrent.*;

public class ExecutorCompletionServiceDemo {
  public static void main( String[] args ) {

    ExecutorService executor = Executors.newCachedThreadPool();
    CompletionService<Integer> completionService =
      new ExecutorCompletionService<>( executor );
    List.of( 4, 3, 2, 1 ).forEach( duration -> completionService.submit( () -> {
      TimeUnit.SECONDS.sleep( duration );
      return duration;
    } ) );
    
    for ( int i = 0; i < 4; i++ ) {
      try {
        System.out.println( completionService.take().get() );
      }
      catch ( InterruptedException | ExecutionException e ) {
        e.printStackTrace();
      }
    }
    
    executor.shutdown();
  }
}
