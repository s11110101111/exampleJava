package com.example.springboot.jtest.demo.straategy_command;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class MainConf {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(MainConf.class);
    }
}
