package com.tutego.insel.oop;

import java.time.LocalDate;
import java.util.Properties;

public interface PropertyReader {

  Properties DEFAULT_PROPERTIES = new Properties();

  $$ $ = new $$();

  static class $$ {
    static {
      DEFAULT_PROPERTIES.setProperty( "date", LocalDate.now().toString() );
    }
  }

  Properties getProperties();
}