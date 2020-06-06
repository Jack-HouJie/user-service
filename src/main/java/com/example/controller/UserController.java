package com.example.controller;

import com.example.service.UserService;
import com.example.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {
  
  @Autowired
  private UserService userService;

  
  // 用户注册：验证邮箱是否已经注册
  // 返回值注解@ResponseBody 直接把字符串作为响应内容
  @PostMapping(path = "/add") 
  public @ResponseBody String addNewUser(@RequestParam String name, @RequestParam String email,
      @RequestParam String password, User user) {
    return userService.addNewUser(name, email, password, user);
  }

  /**
   * 用户登陆：验证用户名是否存在、密码是否正确
   * 
   * @param email    用户邮箱
   * @param password 用户密码
   * @param model    Model层存储处理结果，再由View层渲染。
   * @return
   */
  @PostMapping(path = "/login")
  public String logIn(@RequestParam String email, @RequestParam String password, Model model) {
    return userService.logIn(email, password, model);
  }

  /**
   * 域名根目录进入index.html
   * 
   * @param name
   * @return
   */
  @PostMapping(path = "/")
  public String welcomePage(@RequestParam(name = "name", required = false, defaultValue = "World") String name) {
    return "index";
  }
}