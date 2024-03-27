package com.tutego.insel.bean.validation;


import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class DialogPlayer {
  public interface NameValidation { }
  public interface AgeValidation extends NameValidation { }
  
  @NotNull( groups = NameValidation.class )
  public String name;

  @Min( value = 10, groups = AgeValidation.class )
  @Max( value = 110, groups = AgeValidation.class )
  public int age;
}
