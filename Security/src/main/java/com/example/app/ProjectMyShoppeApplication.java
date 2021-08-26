package com.example.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource({"classpath:application-base.properties"})
public class ProjectMyShoppeApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjectMyShoppeApplication.class, args);
    }

}
