package com.hnayyc.coffee.ioc.annotation;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SetterAnnotation {
    public Class nation();
}

