package com.gupaoedu.mvcframework.annotation;

import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface GPAutowired {
    // 下面这个是 Spring 源码的注释数据 org.springframework.beans.factory.annotation.Autowired
    // boolean required() default true;

    String value() default "";
}
