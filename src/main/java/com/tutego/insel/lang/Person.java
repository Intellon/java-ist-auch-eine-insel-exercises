package com.tutego.insel.lang;

import java.util.Objects;
import java.util.Optional;

class Person {
  private Person spouse;

  public void setSpouse( Person spouse ) {
    this.spouse = Objects.requireNonNull( spouse );
  }

  public void removeSpouse() {
    spouse = null;
  }

  public Optional<Person> getSpouse() {
    return Optional.ofNullable( spouse );
  }
}