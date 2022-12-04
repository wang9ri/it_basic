package com.example.basic.repository;

import static org.junit.jupiter.api.Assertions.*;

import com.example.basic.code.UserRole;
import com.example.basic.entity.Photo;
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
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;


@ActiveProfiles("dev")
@SpringBootTest
@Transactional
@Rollback(value = false)
class PhotoRepositoryTest {

  @Autowired
  private UserRepository userRepository;
  @Autowired
  private PostRepository postRepository;


  @Autowired
  private PhotoRepository photoRepository;


  @BeforeEach
  void setUp() {
  }

  @DisplayName("Photo 등록")
  @Test
  void createPhoto() {

    //given
    User user = User.createMember("01073002857", UserRole.MEMBER, true, 4.0);
    userRepository.save(user);

    Post post = Post.createPost("test_content", "test_location", user);
    postRepository.save(post);

    //when
    Photo photo = Photo.createPhoto("http://ss.png", post);
    photoRepository.save(photo);

    //then
    Assertions.assertThat(photo.getId())
        .isEqualTo(photoRepository.findAll(Sort.by(Sort.Direction.DESC, "id")).get(0).getId());
  }
}