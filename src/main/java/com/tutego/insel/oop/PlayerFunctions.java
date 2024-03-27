package com.tutego.insel.oop;

class PlayerFunctions {

  static void carry( PlayerData data, String newItem ) {
    if ( newItem != null && !newItem.trim().isEmpty() )
      data.item += newItem + ";";
  }

  static void dropAll( PlayerData data ) {
    data.item = "";
  }
}
