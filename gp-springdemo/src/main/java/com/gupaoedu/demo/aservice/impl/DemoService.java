package com.gupaoedu.demo.aservice.impl;

import com.gupaoedu.demo.aservice.IDemoService;
import com.gupaoedu.mvcframework.annotation.GPService;

@GPService
public class DemoService implements IDemoService {

    public String get(String name) {
        return "My name is " + name;
    }
}
