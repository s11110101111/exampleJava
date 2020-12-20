package com.example.springboot.jtest.demo.predator_game;

import org.springframework.stereotype.Component;

@Component
public class PlasmaGun {
    public void shoot(Commando commando){
        System.out.println("Shooting a plasmagun at "+ commando.getClass().getSimpleName());
        if (!commando.getClass().getSimpleName().equals("Dutch")){
            commando.setAlive(false);
        }
        System.out.println(commando.getClass().getSimpleName() +" is alive " + commando.isAlive() );
    }

}
