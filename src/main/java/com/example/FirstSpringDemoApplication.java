package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class FirstSpringDemoApplication {

    // TODO アプリをDocker化
    // TODO iOSアプリ作成
    public static void main(String[] args) {
        SpringApplication.run(FirstSpringDemoApplication.class, args);
    }
}
