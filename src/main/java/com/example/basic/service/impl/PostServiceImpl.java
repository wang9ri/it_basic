package com.example.basic.service.impl;

import com.example.basic.dto.PostRequestDTO;
import com.example.basic.entity.Post;
import com.example.basic.entity.User;
import com.example.basic.repository.PostRepository;
import com.example.basic.service.PostService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

  final private PostRepository postRepository;

  @Override
  public void createPost(PostRequestDTO postRequestDTO, User user) {
    Post post = PostRequestDTOToEntity(postRequestDTO, user);
    postRepository.save(post);
  }

  @Override
  public List<Post> findAll() {
    return null;
  }


  private Post PostRequestDTOToEntity(PostRequestDTO postRequestDTO, User user) {
    Post post = Post.createPost(postRequestDTO.getContent(), postRequestDTO.getLocation(), user);
    return post;
  }
}
