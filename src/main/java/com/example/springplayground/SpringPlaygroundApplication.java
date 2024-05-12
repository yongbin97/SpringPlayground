package com.example.springplayground;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SpringPlaygroundApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringPlaygroundApplication.class, args);
    }

}
