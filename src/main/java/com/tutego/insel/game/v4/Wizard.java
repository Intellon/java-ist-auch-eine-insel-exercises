package com.tutego.insel.game.v4;

class Wizard {

  String name = "";
  int age;

  Wizard name( String name ) { this.name = name; return this; }
  String name() { return name; }

  Wizard age( int item ) { this.age = item; return this; }
  int age() { return age; }

  String format() {
    return name + " ist " + age;
  }
}
