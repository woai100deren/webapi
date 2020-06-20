package com.dj.webapi.api.service;


import com.dj.webapi.api.entity.User;

public interface UserService {
    public User getUserInfo();
    public String login(String username, String password);
}
