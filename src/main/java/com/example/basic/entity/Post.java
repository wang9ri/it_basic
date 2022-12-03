package com.example.basic.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
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

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

}
