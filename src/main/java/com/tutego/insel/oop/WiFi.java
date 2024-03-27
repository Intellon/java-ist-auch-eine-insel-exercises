package com.tutego.insel.oop;
public class WiFi {

  private String password = "+covfefe";
  private boolean isAuthenticated;
  
  boolean authenticate( String password ) {
    return isAuthenticated = this.password.equals( password );
  }

  public boolean isAuthenticated() {
    return isAuthenticated;
  }
}
