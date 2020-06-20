package com.dj.webapi.api.controller;

import com.alibaba.fastjson.JSON;
import com.dj.webapi.api.service.AUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AUserController {
    @Autowired
    AUserService service;

    @RequestMapping(value = "/getUserInfo",method = RequestMethod.GET)
    public String getUserInfo(){
        return JSON.toJSONString(service.getUserInfo());
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(String username,String password){
        return service.login(username,password);
    }
}
