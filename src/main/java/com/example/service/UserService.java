package com.example.service;

import com.example.model.UserRepository;
import com.example.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.springframework.ui.Model;
import org.slf4j.LoggerFactory;
import java.util.List;
import org.springframework.web.bind.annotation.ResponseBody;

@Service
public class UserService {
  private static final Logger log = LoggerFactory.getLogger(UserService.class);
  
  @Autowired
  private UserRepository userRepository;

  public @ResponseBody String add(String name, String email, String password, User user) {
    List<User> users = userRepository.findByEmail(email);
    if (users.get(0) != null) {
      log.warn("用户账号保存失败，邮箱已注册");
      return "注册失败，此邮箱已注册";
    } else {
      user.setName(name);
      user.setEmail(email);
      user.setPassword(password);
      userRepository.save(user);
      log.info(user.toString() + "保存至数据库");
      return "注册成功";
    }
  }

  public String logIn(String email, String password, Model model) {
    List<User> users = userRepository.findByEmail(email);
    // 如果数据库中未查到该账号:
    if (users.get(0) == null) {
      log.warn("attempting to log in with the non-existed account");
    } else {
      User user = users.get(0);
      if (user.getPassword().equals(password)) {
        // 如果密码与邮箱配对成功:
        model.addAttribute("name", user.getName());
        log.warn(user.toString() + " logged in");
      } else {
        // 如果密码与邮箱不匹配:
        model.addAttribute("name", "logging failed");
        log.warn(user.toString() + " failed to log in");
      }
    }
    return "index";
  }

}