package com.example.basic.dto;


import com.example.basic.entity.Photo;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PostRequestDTO {

  private Long userId;
  private String content;
  private String location;
  private List<Photo> photos = new ArrayList<>();

}
