package com.example.springboot.jtest.demo.predator_game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Predator {
    @Autowired
    private PlasmaGun lazer;


    public void fight(Commando commando) {
    lazer.shoot(commando);
    }
   public Predator(){
       System.out.println(getClass().getSimpleName() + " was started. " );
   }


}
