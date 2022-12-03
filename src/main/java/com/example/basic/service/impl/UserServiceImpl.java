package com.example.basic.service.impl;

import com.example.basic.entity.User;
import com.example.basic.repository.UserRepository;
import com.example.basic.service.UserService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;


  @Override
  public List<User> findAll() {
    List<User> users = userRepository.findAll();
    if (users.isEmpty()) {
      throw new NullPointerException();
    }
    return users;
  }
}

