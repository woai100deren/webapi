package com.dj.webapi.web.impl;

import com.dj.webapi.web.entity.WNews;
import com.dj.webapi.web.service.WNewsService;
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
public class WNewsServiceImpl implements WNewsService {
    @Resource    // 自动注入，spring boot会帮我们实例化一个对象
    private JdbcTemplate jdbcTemplate;   // 一个通过JDBC连接数据库的工具类，可以通过这个工具类对数据库进行增删改查
    @Autowired
    private HttpServletRequest request;

    @Override
    public void addNews(WNews news) {
        String sql = "insert into news (image,title,subtitle,content,author) "
                + "VALUES ('"+news.getImage()+"', '"+news.getTitle()+"','"+news.getSubtitle()+"','"+news.getContent()
                + "','"+news.getAuthor()+"');";
        jdbcTemplate.update(sql);
    }

    @Override
    public List<WNews> getAllNews() {
        String sql = "select * from news";
        List<WNews> newsArray = jdbcTemplate.query(sql, new RowMapper<WNews>() {
            @Override
            public WNews mapRow(ResultSet resultSet, int i) throws SQLException {
                WNews news = new WNews();
                news.setId(resultSet.getInt("id"));
                news.setImage(resultSet.getString("image"));
                news.setTitle(resultSet.getString("title"));
                news.setSubtitle(resultSet.getString("subtitle"));
                news.setAuthor(resultSet.getString("author"));
                news.setContent(resultSet.getString("content"));
                news.setAddTime(resultSet.getTimestamp("addTime"));
                return news;
            }
        });
        return newsArray;
    }

    @Override
    public void modifyNews(WNews news) {
        jdbcTemplate.update("update news SET image =?, title=?,subtitle=?,content=?,author=?"
                ,news.getImage(),news.getTitle(),news.getSubtitle(),news.getContent(),news.getAuthor());
    }

    @Override
    public void deleteNews(long id) {
        jdbcTemplate.update("delete from news where id=?",id);
    }

    @Override
    public WNews getNewsById(long id) {
        String sql = "select * from news where id="+id;
        List<WNews> newsArray = jdbcTemplate.query(sql, new RowMapper<WNews>() {
            @Override
            public WNews mapRow(ResultSet resultSet, int i) throws SQLException {
                WNews news = new WNews();
                news.setId(resultSet.getInt("id"));
                news.setImage(resultSet.getString("image"));
                news.setTitle(resultSet.getString("title"));
                news.setSubtitle(resultSet.getString("subtitle"));
                news.setAuthor(resultSet.getString("author"));
                news.setContent(resultSet.getString("content"));
                news.setAddTime(resultSet.getTimestamp("addTime"));
                return news;
            }
        });

        return newsArray.get(0);
    }
}
