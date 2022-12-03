package com.example.basic.entity;


import com.example.basic.code.UserRole;
import com.sun.istack.NotNull;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(of = {"id", "role", "mobileNumber"})
@Table(name = "users")
public class User extends BaseTimeEntity {

    /*

    @Column(columnDefinition = "varchar(255) default 'John Snow'")
    private String name;

    @Column(columnDefinition = "integer default 25")
    private Integer age;

    @Column(columnDefinition = "boolean default false")
     */

  @Id
  @GeneratedValue
  @Column(name = "user_id")
  private long id;

  @NotNull
  @Enumerated(value = EnumType.STRING)
  private UserRole role;


  @NotNull
  private String mobileNumber;

  @NotNull
  private boolean activated;


  @NotNull
  private double ratingScore;

  @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
  private List<Notification> notifications = new ArrayList();

  @OneToMany(mappedBy = "user")
  private List<Post> posts = new ArrayList<>();

  public static User createMember(String mobileNumber, UserRole role, boolean activated,
      double ratingScore) {

    User user = new User();
    user.setMobileNumber(mobileNumber);
    user.setRole(role);
    user.setActivated(activated);
    user.setRatingScore(ratingScore);

    return user;
  }

}
