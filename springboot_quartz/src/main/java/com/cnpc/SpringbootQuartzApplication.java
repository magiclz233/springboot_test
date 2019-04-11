package com.cnpc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringbootQuartzApplication {

    public static void main(String[] args) {
        SpringApplication.run( SpringbootQuartzApplication.class, args );
    }

}
