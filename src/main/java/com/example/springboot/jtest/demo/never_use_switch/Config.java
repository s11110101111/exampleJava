package com.example.springboot.jtest.demo.never_use_switch;

import com.github.javafaker.Faker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.Locale;

@Configuration
@ComponentScan
@EnableScheduling
public class Config {

    @Bean
    public Faker faker(){
        return  new Faker(new Locale("ru"));
    }

}
