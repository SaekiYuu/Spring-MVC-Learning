package com.saekiyuu.learning.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloWorldController {
    @GetMapping(value = "/hello")
    @ResponseBody
    public String hello() {
        return "Hello, world!";
    }

    /*
    @GetMapping(value = "/get-json")
    @ResponseBody
    public List<Integer> getJson() {
        List<Integer> ret = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            ret.add(10 - i);
        }
        return ret;
    } */
}
