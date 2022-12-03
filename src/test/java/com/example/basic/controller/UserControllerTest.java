package com.example.basic.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.basic.code.UserRole;
import com.example.basic.entity.User;
import com.example.basic.service.impl.UserServiceImpl;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/**
 * @WebMvcTest - JPA 기능은 동작하지 않는다. - 여러 스프링 테스트 어노테이션 중, Web(Spring MVC)에만 집중할 수 있는 어노테이션 -
 * @Controller, @ControllerAdvice 사용 가능 - 단, @Service, @Repository등은 사용할 수 없다.
 */
@WebMvcTest(UserController.class)
@ActiveProfiles("dev")
class UserControllerTest {

  @MockBean
  private UserServiceImpl userServiceImpl;

  @Autowired
  /**
   * 웹 API 테스트할 때 사용
   * 스프링 MVC 테스트의 시작점
   * HTTP GET,POST 등에 대해 API 테스트 가능
   * */
      MockMvc mockMvc;

  @BeforeEach
  public void setUp() {
    mockMvc =
        MockMvcBuilders.standaloneSetup(new UserController(userServiceImpl))
//            .addFilters(new CharacterEncodingFilter("UTF-8", true)) // utf-8 필터 추가
            .build();
  }

  @Test
  @DisplayName("사용자목록조회")
  public void findAllUsers() throws Exception {

    List<User> users = Arrays.asList(User.createMember("01073002857", UserRole.MEMBER, true, 4.5));
    when(userServiceImpl.findAll()).thenReturn(users);

    mockMvc.perform(get("/users"))
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/json"))
        .andDo(print());

  }

}