package com.example.basic.controller;

import com.example.basic.dto.PostRequestDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {



  @PostMapping("/posts")
  public void createPost(PostRequestDTO postRequestDTO) {

  }

}
