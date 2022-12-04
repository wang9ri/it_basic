package com.example.basic.service.impl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import com.example.basic.code.UserRole;
import com.example.basic.config.ModelMapperConfig;
import com.example.basic.controller.UserController;
import com.example.basic.dto.PostRequestDTO;
import com.example.basic.entity.User;
import com.example.basic.repository.PostRepository;
import com.example.basic.repository.UserRepository;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;


@ActiveProfiles("dev")
@ExtendWith(MockitoExtension.class)
//@SpringBootTest(classes = {ModelMapperConfig.class})
class PostServiceImplTest {

  @Mock
  private PostRepository postRepository;

  @Mock
  private UserController userController;

//  @Autowired
//  private ModelMapper modelMapper;
//
//  @InjectMocks
//  private PostServiceImpl postServiceImpl;


  @BeforeEach
  void setUp() {
  }

  @Test
  void createPost() {

    //given
    when(userController.findByid(any())).thenReturn(
        User.createMember("01073002857", UserRole.MEMBER, true, 4.5));
    User user = userController.findByid(1l);
    PostRequestDTO postRequestDTO = new PostRequestDTO();

    postRequestDTO.setContent("test_content");
    postRequestDTO.setLocation("test_location");
    PostServiceImpl postServiceImpl = new PostServiceImpl(postRepository);
    postServiceImpl.createPost(postRequestDTO, user);
  }
}