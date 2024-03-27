package com.tutego.insel.logging;

import java.time.Instant;
import java.util.logging.Level;
import java.util.logging.Logger;

import static java.time.Instant.now;
import static java.time.temporal.ChronoUnit.MILLIS;

public class JULDemo {

  private static final Logger log = Logger.getLogger( JULDemo.class.getName() );

  public static void main( String[] args ) {
    Instant start = now();
    log.info( "Wir starten mit JUL" );

    try {
      log.log( Level.INFO, "In {0} Sekunden geht es los", 0 );
      log.logp( Level.INFO, "", "", "In {0} Sekunden geht es los", 0 );
      throw null;
    }
    catch ( Exception e ) {
      log.log( Level.SEVERE, "Oh Oh", e );
    }
    log.info( () -> String.format( "Laufzeit %s ms", start.until( now(), MILLIS ) ) );
  }
}