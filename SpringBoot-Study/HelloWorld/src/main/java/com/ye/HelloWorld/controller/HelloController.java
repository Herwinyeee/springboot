package com.ye.HelloWorld.controller;

//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String halo(){
        return "hello";
    }
}
