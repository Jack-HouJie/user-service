package com.example.controller;

import com.example.service.UserService;
import com.example.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {
  
  @Autowired
  private UserService userService;

  // 返回值注解@ResponseBody 直接把字符串作为响应，而不是html页面
  @GetMapping(path = "/add") 
  public @ResponseBody String addNewUser(@RequestParam String name, @RequestParam String email,
      @RequestParam String password, User user) {
    return userService.addNewUser(name, email, password, user);
  }

  /**
   * 登陆方法, 用户输入邮箱和密码, 查询数据库检验是否有该账户,如果有, 返回原先页面 ,登陆成功。
   * 
   * @param email    用户邮箱
   * @param password 用户密码
   * @param model    Spring MVC中的Model，用来储存经过controller处理后的信息，再由View层渲染 得到前端页面。
   * @return
   */
  @GetMapping(path = "/login")
  public String logIn(@RequestParam String email, @RequestParam String password, Model model) {
    return userService.logIn(email, password, model);
  }

  /**
   * 域名的根目录，然后返回的“index”会映射到 java/resources/templates/index.html文件。
   * 
   * @param name
   * @return
   */
  @GetMapping(path = "/")
  public String welcomePage(@RequestParam(name = "name", required = false, defaultValue = "World") String namel) {
    return "index";
  }

}