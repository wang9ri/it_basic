package com.example.basic.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import lombok.Getter;

@Entity
@Getter
public class Post {

  @Id
  @GeneratedValue
  @Column(name = "postId")
  private Long id;
  private String content;
  private String location;

  @ManyToOne
  @JoinColumn(name = "user_id", nullable = false)
  private User user;

  @OneToMany(mappedBy = "post")
  private List<Photo> photos = new ArrayList<>();


  public static Post createPost(String content, String location, User user) {
    Post post = new Post();
    post.content = content;
    post.location = location;
    post.user = user;

    return post;
  }


}
