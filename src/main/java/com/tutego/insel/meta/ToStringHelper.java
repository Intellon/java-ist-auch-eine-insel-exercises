package com.tutego.insel.meta;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;

public class ToStringHelper {
  public static String toString( Object o ) {
    Collection<String> result = new ArrayList<>();

    toString( o, o.getClass(), result );

    return o.getClass().getName().concat( result.toString() );
  }

  private static void toString( Object o, Class<?> clazz,
                                Collection<String> list ) {
    Field[] fields = clazz.getDeclaredFields();
    AccessibleObject.setAccessible( fields, true );

    for ( Field f : fields ) {
      try {
        list.add( f.getName() + "=" + f.get( o ) );
      }
      catch ( IllegalAccessException e ) {
        e.printStackTrace();
      }
    }
    if ( clazz.getSuperclass().getSuperclass() != null )
      toString( o, clazz.getSuperclass(), list );
  }
}