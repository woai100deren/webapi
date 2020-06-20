package com.dj.webapi.web.service;

import com.dj.webapi.web.entity.WUser;

import java.util.List;

public interface WUserService {
    /**
     * 注册用户
     * @param user 用户信息
     */
    void registerUser(WUser user);

    /**
     * 获取所有用户
     */
    List<WUser> getAllUser();
    /**
     * 修改用户信息
     * @param user 用户
     */
    void modifyUser(WUser user);
    /**
     * 删除用户
     * @param id 用户编号
     */
    void deleteUser(long id);

    /**
     * 根据用户id查询用户
     * @param id 用户id
     * @return 用户信息
     */

    WUser getUserById(long id);
}
