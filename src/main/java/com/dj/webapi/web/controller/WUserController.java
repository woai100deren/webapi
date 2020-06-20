package com.dj.webapi.web.controller;

import com.dj.webapi.web.entity.WUser;
import com.dj.webapi.web.service.WUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/users")
public class WUserController {
    @Autowired
    WUserService service;
    @GetMapping("/add")
    public ModelAndView addPage(Model model) {
        model.addAttribute("user",new WUser());
        model.addAttribute("title", "创建用户");
        return new ModelAndView("users/add","userModel",model);
    }

    @RequestMapping("/addUser")
    public ModelAndView addUser(WUser user) {
        service.registerUser(user);
        return new ModelAndView("redirect:/users");//重定向到list页面
    }

    /**
     * 查询用户
     * @param model
     * @return
     */
    @GetMapping
    public ModelAndView list(Model model) {
        model.addAttribute("userList",service.getAllUser());
        model.addAttribute("title", "用户管理");
        return new ModelAndView("users/list","userModel",model);
    }
    /**
     * 根据用户id查看用户
     * @param id 用户编号
     * @param model
     * @return
     */
    @GetMapping("{id}")
    public ModelAndView view(@PathVariable("id") Long id, Model model) {
        WUser user = service.getUserById(id);
        model.addAttribute("user",user);
        model.addAttribute("title", "查看用户");
        return new ModelAndView("users/view","userModel",model);
    }
}
