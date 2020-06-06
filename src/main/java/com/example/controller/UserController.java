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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@RequestMapping("/user")
public class UserController {

  @Autowired
  private UserService userService;


    /**
   * 域名根目录进入index.html
   * 
   * @param name
   * @return
   */
  @RequestMapping(method = RequestMethod.GET)
  public String welcomePage(@RequestParam(name = "name", required = false, defaultValue = "World") String name) {
    return "index";
  }

  // 用户注册：验证邮箱是否已经注册
  // 返回值注解@ResponseBody 直接把字符串作为显示内容
  @RequestMapping(value="/add", method = RequestMethod.POST)
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
  @RequestMapping(value="/login", method = RequestMethod.POST)
  public String logIn(@RequestParam String email, @RequestParam String password, Model model) {
    return userService.logIn(email, password, model);
  }


  @RequestMapping(value="/{userId}", method = RequestMethod.GET)
  public User getUsers(@PathVariable(name = "userId") Long userId){
    return userService.findOne(userId);
  }

}