package com.daxian.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {
    @RequestMapping("/sayHello")
    public String sayHello(){
        System.out.println("sayHello");
        return "success";
    }
}
