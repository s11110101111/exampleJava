package com.example.springboot.jtest.demo.predator_game;

import org.springframework.stereotype.Service;

@Service
public class Predator {
    public void fight(Commando commando) {
    commando.setAlive(false);
    }
   public Predator(){
       System.out.println("");
       System.out.println(getClass().getSimpleName() + " was started. " );
   }


}
