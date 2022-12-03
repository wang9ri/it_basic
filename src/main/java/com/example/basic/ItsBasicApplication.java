package com.example.basic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
public class ItsBasicApplication {

    public static void main(String[] args) {
        SpringApplication.run(ItsBasicApplication.class, args);
    }

}
