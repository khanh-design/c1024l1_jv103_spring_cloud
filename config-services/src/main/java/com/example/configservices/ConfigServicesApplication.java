package com.example.configservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.ConfigServerApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@EnableConfigServer
public class ConfigServicesApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigServicesApplication.class, args);
    }

}
