package com.example;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class EasycrudApplication {

    public static void main(String[] args) {
        log.info("s");
        SpringApplication.run(EasycrudApplication.class, args);
    }

}
