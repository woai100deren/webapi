package com.dj.webapi.web.service;

import com.dj.webapi.web.entity.WNews;

import java.util.List;

public interface WNewsService {
    /**
     * 新增新闻
     * @param news 新闻
     */
    void addNews(WNews news);

    /**
     * 获取所有新闻
     */
    List<WNews> getAllNews();
    /**
     * 修改新闻信息
     * @param news 新闻
     */
    void modifyNews(WNews news);
    /**
     * 删除新闻
     * @param id 新闻编号
     */
    void deleteNews(long id);

    /**
     * 根据id查询新闻
     * @param id 新闻id
     * @return 新闻信息
     */

    WNews getNewsById(long id);
}
