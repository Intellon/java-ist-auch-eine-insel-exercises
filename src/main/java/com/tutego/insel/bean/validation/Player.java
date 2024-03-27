package com.tutego.insel.bean.validation;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class Player {

  private String name;

  @Min(10)
  @Max(110)
  private int    age;
  
  public void setName( String name ) {
    this.name = name;
  }

  @NotNull
  public String getName() {
    return name;
  }

  public void setAge( int age ) {
    this.age = age;
  }

  public int getAge() {
    return age;
  }
}
