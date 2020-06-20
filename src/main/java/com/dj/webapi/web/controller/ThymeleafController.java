package com.dj.webapi.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class ThymeleafController {

    @RequestMapping("home")
    public String hello(Map<String,Object> map) {
        map.put("msg", "Hello Thymeleaf");
        return "home";
    }
}