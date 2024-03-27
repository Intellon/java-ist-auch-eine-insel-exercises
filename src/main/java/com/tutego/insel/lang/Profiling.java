package com.tutego.insel.lang;

import static java.util.concurrent.TimeUnit.NANOSECONDS;
import java.util.Arrays;
import java.util.function.Supplier;
import java.util.function.ToLongFunction;

class Profiling {

  final static String ANGIE =
    "Aber Angie, Angie, ist es nicht an der Zeit, Goodbye zu sagen? " +
    "Ohne Liebe in unseren Seelen und ohne Geld in unseren Mänteln. " +
    "Du kannst nicht sagen, dass wir zufrieden sind.";

  final static int MAX = 10000;

  enum Algorithm {
    STRING_BUILDER1( () -> { // StringBuffer(size) und append() zur Konkatenation
      StringBuilder sb = new StringBuilder( 2 * MAX * ANGIE.length() );
      for ( int i = MAX; i-- > 0; )
        sb.append( ANGIE ).append( ANGIE );
      return sb.toString().length();
    } ),
    STRING_BUILDER2( () -> { // StringBuffer und append() zur Konkatenation
      StringBuilder sb = new StringBuilder();
      for ( int i = MAX; i-- > 0; )
        sb.append( ANGIE ).append( ANGIE );
      return sb.toString().length();
    } ),
    STRING_PLUS( () -> {     // + zur Konkatenation
      String s = "";
      for ( int i = MAX; i-- > 0; )
        s += ANGIE + ANGIE;
      return s.length();
    } );

    private final Supplier<Integer> supplier;
    private Algorithm( Supplier<Integer> supplier ) { this.supplier = supplier; }
    int perform() { return supplier.get(); }
  }

  private static long[] measure() {
    ToLongFunction<Algorithm> duration = algorithm -> {
      long startTime = System.nanoTime();
      int result = algorithm.perform();
      try { return NANOSECONDS.toMillis( System.nanoTime() - startTime ); }
      finally { System.out.println( result ); }
    };
    return Arrays.stream( Algorithm.values() ).mapToLong( duration ).toArray();
  }

  public static void main( String[] args ) {
    measure(); System.gc(); measure(); System.gc(); 
    long[] durations = measure();

    System.out.printf( "sb(size), append(): %d ms%n", durations[0] ); // sb(size), append(): 6 ms
    System.out.printf( "sb(), append()    : %d ms%n", durations[1] ); // sb(), append()    : 9 ms
    System.out.printf( "t+=               : %d ms%n", durations[2] ); // t+=               : 15982 ms
  }
}
