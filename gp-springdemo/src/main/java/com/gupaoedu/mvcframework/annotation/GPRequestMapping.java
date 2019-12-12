package com.gupaoedu.mvcframework.annotation;

import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface GPRequestMapping {

    // Spring 源码包: org.springframework.web.bind.annotation.RequestMapping
    String value() default "";
}
