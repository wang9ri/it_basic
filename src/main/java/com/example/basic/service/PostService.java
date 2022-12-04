package com.example.basic.service;

import com.example.basic.dto.PostRequestDTO;
import com.example.basic.entity.Post;
import com.example.basic.entity.User;
import java.util.List;

public interface PostService {

  void createPost(PostRequestDTO postRequestDTO, User user);

  List<Post> findAll();
}
