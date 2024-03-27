package com.tutego.insel.oop;

import java.util.Date;
import java.util.Properties;

public interface PropertyReader2 {

  Properties DEFAULT_PROPERTIES = $$.$();

  static class $$ {
    static Properties $() {
      Properties p = new Properties();
      p.setProperty( "date", new Date().toString() );
      return p;
    }
  }

  Properties getProperties();
}