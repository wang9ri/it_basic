package com.example.basic.service;

import com.example.basic.entity.User;
import java.util.List;
import org.springframework.stereotype.Service;

public interface UserService {

  List<User> findAll();

  User findById(Long id);
}
