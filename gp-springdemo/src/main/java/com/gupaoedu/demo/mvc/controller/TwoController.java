package com.gupaoedu.demo.mvc.controller;

import com.gupaoedu.demo.aservice.IDemoService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TwoController {

    private IDemoService demoService;

    public void edit(HttpServletRequest req, HttpServletResponse resp,
                     String name) {
       try {
           String result = demoService.get(name);
           resp.getWriter().write(result);
       } catch(Exception ex) {
           ex.printStackTrace();
       }
    }
}
