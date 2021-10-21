package com.usdgif.usdgif;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class UsdgifApplication {

    public static void main(String[] args) {
        SpringApplication.run(UsdgifApplication.class, args);
    }

}
