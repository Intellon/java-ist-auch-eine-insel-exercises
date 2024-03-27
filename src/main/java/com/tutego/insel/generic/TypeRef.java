package com.tutego.insel.generic;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public abstract class TypeRef<T> {
  
  public final Type type;

  protected TypeRef() {
    ParameterizedType superclass = (ParameterizedType) getClass().getGenericSuperclass();
    type = superclass.getActualTypeArguments()[0];
  }
}