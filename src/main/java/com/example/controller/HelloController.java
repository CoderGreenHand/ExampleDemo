package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @RequestMapping("hello")
    @ResponseBody
    public String hello(){
        System.out.println("进入方法");
        return "hello";
    }

}
