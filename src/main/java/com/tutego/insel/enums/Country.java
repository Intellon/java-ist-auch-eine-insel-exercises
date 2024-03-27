package com.tutego.insel.enums;

public enum Country {

  GERMANY, UK, CHINA;

  public String getISO3Country() {
    switch ( this ) {
      case GERMANY : return "DEU";
      case UK      : return "GBR";
      default      : return "CHN";
    }
  }
}