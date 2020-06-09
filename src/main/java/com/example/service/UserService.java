package com.example.service;

import com.example.model.UserRepository;
import com.example.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

@Service
public class UserService {
  private static final Logger log = LoggerFactory.getLogger(UserService.class);

  @Autowired
  private UserRepository userRepository;

  public String setUser(Long userId, String name, String email, String password, String gender, String age,
      String occupation, String zipcode) {
    User user = userRepository.findOne(userId);
    user.setName(name);
    user.setEmail(email);
    user.setPassword(password);
    user.setType("user");
    user.setGender(gender);
    user.setAge(age);
    user.setOccupation(occupation);
    user.setZipcode(zipcode);
    log.info(user.toString() + "数据已更新");
    return "true";
  }

  public String addUser(String name, String email, String password, String gender, String age, String occupation,
      String zipcode, User user) {
    List<User> users = userRepository.findByEmail(email);
    if (users.size() != 0) {
      // 邮箱已注册时：
      log.warn("用户账号保存失败，邮箱已注册");
      return "false";
    } else {
      user.setName(name);
      user.setEmail(email);
      user.setPassword(password);
      user.setType("user");
      user.setGender(gender);
      user.setAge(age);
      user.setOccupation(occupation);
      user.setZipcode(zipcode);
      userRepository.save(user);
      log.info(user.toString() + "保存至数据库");
      return "true";
    }
  }

  public String logIn(String email, String password) {
    List<User> users = userRepository.findByEmail(email);
    if (users.size() == 0) {
      // 帐号不存在时:
      log.warn("账号不存在，登陆失败");
      return "false";
    } else {
      User user = users.get(0);
      if (user.getPassword().equals(password)) {
        // 密码正确时:
        log.info(user.toString() + " 登陆成功 ");
        return "true";
      } else {
        // 密码错误时:
        log.warn(user.toString() + " 登陆失败 ");
        return "false";
      }
    }
  }

  public User getUser(Long userId) {
    return userRepository.findOne(userId);
  }
}