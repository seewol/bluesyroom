package com.example.bluesyroom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class BluesyroomApplication {

    public static void main(String[] args) {
        SpringApplication.run(BluesyroomApplication.class, args);
    }

}
