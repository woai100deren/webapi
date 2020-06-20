package com.dj.webapi.api.impl;

import com.dj.webapi.api.entity.User;
import com.dj.webapi.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Resource    // 自动注入，spring boot会帮我们实例化一个对象
    private JdbcTemplate jdbcTemplate;   // 一个通过JDBC连接数据库的工具类，可以通过这个工具类对数据库进行增删改查
    @Autowired
    private HttpServletRequest request;

    @Override
    public User getUserInfo() {
        String sql = "select id,username,password from user";
        List<User> students = jdbcTemplate.query(sql, new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet resultSet, int i) throws SQLException {
                User student = new User();
                student.setId(resultSet.getInt("id"));
                student.setUsername(resultSet.getString("username"));
                student.setPassword(resultSet.getString("password"));
                return student;
            }
        });

        return students.get(0);
    }

    @Override
    public String login(String username, String password) {
        if("wangjing".equals(username) && "123456".equals(password)) {
            return "{\"resultCode\":\"0\",\"resultMsg\":\"登录成功\"}";
        }
        return "{\"resultCode\":\"1\",\"resultMsg\":\"登录失败\"}";
    }
}
