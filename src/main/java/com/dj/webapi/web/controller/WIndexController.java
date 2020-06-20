package com.dj.webapi.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class WIndexController {

    @RequestMapping("index")
    public String hello(Map<String,Object> map) {
        return "index";
    }
}