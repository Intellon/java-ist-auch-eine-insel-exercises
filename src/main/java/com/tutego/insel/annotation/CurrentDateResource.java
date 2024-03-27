package com.tutego.insel.annotation;

import java.lang.annotation.*;

@Documented
@Target( ElementType.FIELD )
@Retention( RetentionPolicy.RUNTIME )
public @interface CurrentDateResource { }
