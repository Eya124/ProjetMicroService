package com.example.centre;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication
@EnableDiscoveryClient
public class CentreApplication {

    public static void main(String[] args) {
        SpringApplication.run(CentreApplication.class, args);
    }

}