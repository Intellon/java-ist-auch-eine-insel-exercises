package com.tutego.insel.game.vi;

public class Door extends GameObject {

  int     id;
  boolean isOpen;

  public Door( int id ) { this.id = id; }

  @Override public boolean useOn( GameObject object ) {
    return false;
  }
}
