package com.quizapp.question_registory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class QuestionRegistoryApplication {

    public static void main(String[] args) {
        SpringApplication.run(QuestionRegistoryApplication.class, args);
    }

}
