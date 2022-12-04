package com.example.basic.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Getter;

@Entity
@Getter
public class Photo {

  @Id
  @GeneratedValue
  private Long id;

  private String url;
  @ManyToOne
  @JoinColumn(name = "post_id")
  private Post post;

  public static Photo createPhoto(String url, Post post) {

    Photo photo = new Photo();
    photo.url = url;
    photo.post = post;

    return photo;
  }

}
