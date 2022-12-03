package com.example.basic.repository;

import com.example.basic.code.UserRole;
import com.example.basic.entity.Comment;
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
//@Rollback(value = false)
class CommentRepositoryTest {

  @Autowired
  private UserRepository userRepository;
  @Autowired
  private PostRepository postRepository;

  @Autowired
  private CommentRepository commentRepository;


  @BeforeEach
  void setUp() {
  }

  @DisplayName("댓글 등록")
  @Test
  void testCreateComment() {

    //given
    User user = User.createMember("01073002857", UserRole.MEMBER, true, 4.0);
    userRepository.save(user);

    Post post = new Post();
    post.setContent("1st comment");
    post.setLocation("seoul");
    post.setUser(user);
    postRepository.save(post);

    //when

    //then

    Comment comment = Comment.createComment("하하하 댓글", user, post);

    commentRepository.save(comment);

    Assertions.assertThat(comment.getId())
        .isEqualTo(commentRepository.findAll(Sort.by(Sort.Direction.DESC, "id")).get(0).getId());


  }

  @DisplayName("대댓글 등록")
  @Test
  void testCreateCommentParentId() {
    //given
    User user = User.createMember("01073002857", UserRole.MEMBER, true, 4.0);
    userRepository.save(user);

    Post post = new Post();
    post.setContent("1st comment");
    post.setLocation("seoul");
    post.setUser(user);
    postRepository.save(post);

    //when

    Comment firstComment = Comment.createComment("댓글", user, post);
    commentRepository.save(firstComment);
    //then
    Comment secondComment = Comment.createCommentParentId("대댓글", user, post,
        firstComment.getId());
    commentRepository.save(secondComment);

    Assertions.assertThat(secondComment.getId())
        .isEqualTo(commentRepository.findAll(Sort.by(Sort.Direction.DESC, "id")).get(0).getId());

  }

}