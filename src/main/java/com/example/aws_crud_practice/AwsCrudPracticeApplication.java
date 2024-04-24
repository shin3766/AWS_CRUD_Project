package com.example.aws_crud_practice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class AwsCrudPracticeApplication {

    public static void main(String[] args) {
        SpringApplication.run(AwsCrudPracticeApplication.class, args);
    }

}
