package com.example.basic.repository;

import com.example.basic.code.UserRole;
import com.example.basic.entity.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Rollback(value = false)
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    void setUp() {
    }

    @DisplayName("사용자 등록")
    @Test
    void saveUser() {
        User user = User.createMember("01073002857", UserRole.MEMBER, true, 4.0);
        userRepository.save(user);

        User savedUser = userRepository.findById(user.getId()).get();


        Assertions.assertThat(user.getMobileNumber()).isEqualTo(savedUser.getMobileNumber());

    }
}