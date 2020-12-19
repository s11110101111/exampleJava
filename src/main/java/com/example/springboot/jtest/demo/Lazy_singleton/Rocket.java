package com.example.springboot.jtest.demo.Lazy_singleton;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
@Lazy
public class Rocket {
   @PostConstruct
    private void init(){
       System.out.println("Rocket is get.");
   }

    public void hit(){
        System.out.println(" Rocket Bang bang!!!");
    }
}
