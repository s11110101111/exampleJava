package com.example.springboot.jtest.demo.Lazy_singleton;

import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class MainConf {
    public static void main(String[] args) {
        SpringApplication.run(MainConf.class);
    }
}
