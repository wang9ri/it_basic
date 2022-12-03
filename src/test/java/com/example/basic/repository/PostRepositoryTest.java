package com.example.basic.repository;

import com.example.basic.entity.Post;
import com.example.basic.entity.User;
import javax.transaction.Transactional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("dev")
@SpringBootTest
@Transactional
//@Rollback(value = false)
class PostRepositoryTest {

  @Autowired
  private UserRepository userRepository;
  @Autowired
  private PostRepository postRepository;


  @BeforeEach
  void setUp() {
  }

  @DisplayName("Post 등록")
  @Test
  void savePost() {
    User user = userRepository.findAll().get(0);

    Post post = new Post();
    post.setContent("dd");
    post.setLocation("dddd");
    post.setUser(user);
    postRepository.save(post);

    Assertions.assertThat(post.getId())
        .isEqualTo(postRepository.findAll(Sort.by(Sort.Direction.DESC, "id")).get(0).getId());
  }
}