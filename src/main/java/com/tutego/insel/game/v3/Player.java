package com.tutego.insel.game.v3;

class Player {

  String name = "";
  String item = "";

  void carry( String newItem ) {
    if ( newItem != null && !newItem.trim().isEmpty() )
      item += newItem.trim() + ";";
  }

  boolean doesCarryAnything() {
    return ! item.isEmpty();
  }
  
  void dropAll() {
    item = "";
  }
}