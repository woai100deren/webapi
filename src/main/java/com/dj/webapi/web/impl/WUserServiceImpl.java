package com.dj.webapi.web.impl;

import com.dj.webapi.api.entity.AUser;
import com.dj.webapi.web.entity.WUser;
import com.dj.webapi.web.service.WUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class WUserServiceImpl implements WUserService {
    @Resource    // 自动注入，spring boot会帮我们实例化一个对象
    private JdbcTemplate jdbcTemplate;   // 一个通过JDBC连接数据库的工具类，可以通过这个工具类对数据库进行增删改查
    @Autowired
    private HttpServletRequest request;
    @Override
    public void registerUser(WUser user) {
        String sql = "insert into USER (`username`, `password`) "
                + "VALUES ('"+user.getUsername()+"', "+user.getPassword()+");";
        jdbcTemplate.update(sql);
    }

    @Override
    public List<WUser> getAllUser() {
        String sql = "select id,username,password from user";
        List<WUser> users = jdbcTemplate.query(sql, new RowMapper<WUser>() {
            @Override
            public WUser mapRow(ResultSet resultSet, int i) throws SQLException {
                WUser student = new WUser();
                student.setId(resultSet.getInt("id"));
                student.setUsername(resultSet.getString("username"));
                student.setPassword(resultSet.getString("password"));
                return student;
            }
        });
        return users;
    }

    @Override
    public WUser modifyUser(WUser user) {
        return null;
    }

    @Override
    public void deleteUser(long id) {

    }

    @Override
    public WUser getUserById(long id) {
        return null;
    }
}
