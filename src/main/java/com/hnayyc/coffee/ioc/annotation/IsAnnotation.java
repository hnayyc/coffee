package com.hnayyc.coffee.ioc.annotation;

import java.lang.annotation.*;

/**
 * 用来判断该类是否可以用来使用注入
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface IsAnnotation {
}
