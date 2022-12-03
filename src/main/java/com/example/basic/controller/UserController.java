package com.example.basic.controller;

import com.example.basic.entity.User;
import com.example.basic.service.UserService;
import com.example.basic.service.impl.UserServiceImpl;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

  private final UserService userService;

  public UserController(UserServiceImpl userServiceImpl) {
    this.userService = userServiceImpl;
  }


  @GetMapping("/users")
  public List<User> findAllUsers() {

    return userService.findAll();
  }
}
