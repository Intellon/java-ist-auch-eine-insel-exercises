package com.tutego.insel.tool;

import java.time.LocalDate;

public class HambachForest {
  public static void main( String[] args ) {
    boolean rweWantsToCutTrees = true;
    Forrest hambachForest = new Forrest();
    if ( rweWantsToCutTrees ) {
      Protest<Forrest> p1 = new Protest<>();
      p1.believeIn = hambachForest;
    }
  }
}

class Forrest { }

class Protest<T> {
  T believeIn;
  java.time.LocalDate since = LocalDate.now();
}