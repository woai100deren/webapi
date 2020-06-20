package com.dj.webapi.api.service;


import com.dj.webapi.api.entity.AUser;

public interface AUserService {
    public AUser getUserInfo();
    public String login(String username, String password);
}
