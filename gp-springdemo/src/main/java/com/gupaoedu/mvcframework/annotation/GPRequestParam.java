package com.gupaoedu.mvcframework.annotation;

import java.lang.annotation.*;

@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface GPRequestParam {

    // Spring 源码包: org.springframework.web.bind.annotation.RequestParam
    String value() default "";
}
