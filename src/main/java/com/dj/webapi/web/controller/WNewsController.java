package com.dj.webapi.web.controller;

import com.dj.webapi.web.entity.WNews;
import com.dj.webapi.web.service.WNewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/news")
public class WNewsController {
    @Autowired
    WNewsService service;

    /**
     * 新增新闻页面
     * @param model
     * @return
     */
    @GetMapping("/add")
    public ModelAndView addPage(Model model) {
        model.addAttribute("news",new WNews());
        model.addAttribute("title", "新闻录入");
        return new ModelAndView("news/add","newsModel",model);
    }

    /**
     * 新增新闻
     * @param news
     * @return
     */
    @RequestMapping("/addNews")
    public ModelAndView addUser(WNews news) {
        service.addNews(news);
        return new ModelAndView("redirect:/news");//重定向到list页面
    }

    /**
     * 修改新闻界面
     * @param model
     * @return
     */
    @GetMapping("/modify/{id}")
    public ModelAndView modifyPage(@PathVariable("id") long id, Model model) {
        model.addAttribute("news",service.getNewsById(id));
        model.addAttribute("title", "修改新闻");
        return new ModelAndView("news/modify","newsModel",model);
    }
    /**
     * 修改新闻
     * @param news 新闻
     * @return
     */
    @RequestMapping("/modifyNews")
    public ModelAndView modifyNews(WNews news) {
        service.modifyNews(news);
        return new ModelAndView("redirect:/news");//重定向到list页面
    }

    /**
     * 查询用户
     * @param model
     * @return
     */
    @GetMapping
    public ModelAndView news(Model model) {
        model.addAttribute("newsList",service.getAllNews());
        model.addAttribute("title", "新闻管理");
        return new ModelAndView("news/list","newsModel",model);
    }

    /**
     * 根据id查看新闻
     * @param id 编号
     * @param model
     * @return
     */
    @GetMapping("{id}")
    public ModelAndView view(@PathVariable("id") long id, Model model) {
        WNews news = service.getNewsById(id);
        model.addAttribute("news",news);
        model.addAttribute("title", "新闻详情");
        return new ModelAndView("news/detail","newsModel",model);
    }

    /**
     * 删除新闻，并返回新闻列表
     * @param id id
     * @return
     */
    @GetMapping("/delete/{id}")
    public ModelAndView deleteNews(@PathVariable("id") long id) {
        service.deleteNews(id);
        return new ModelAndView("redirect:/news");//重定向到list页面
    }
}
