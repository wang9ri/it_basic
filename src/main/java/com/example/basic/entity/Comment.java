package com.example.basic.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Getter;

@Entity
@Getter
public class Comment {

  @Id
  @GeneratedValue
  @Column(name = "comment_id")
  private Long id;

  private String content;
  private Long parentId;


  @ManyToOne
  @JoinColumn(name = "user_id", nullable = false)
  private User user;

  @ManyToOne
  @JoinColumn(name = "post_id", nullable = false)
  private Post post;

  public static Comment createComment(String content, User user, Post post) {

    Comment comment = new Comment();
    comment.content = content;
    comment.user = user;
    comment.post = post;

    return comment;
  }

  public static Comment createCommentParentId(String content, User user, Post post,
      Long parentId) {

    Comment comment = createComment(content, user, post);
    comment.parentId = parentId;

    return comment;
  }
}
