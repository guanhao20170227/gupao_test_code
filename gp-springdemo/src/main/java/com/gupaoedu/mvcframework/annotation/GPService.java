package com.gupaoedu.mvcframework.annotation;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface GPService {
    // Spring 源码包: org.springframework.stereotype .Service

    String value() default "";
}
