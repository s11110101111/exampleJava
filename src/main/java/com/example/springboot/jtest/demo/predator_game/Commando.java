package com.example.springboot.jtest.demo.predator_game;

import lombok.Data;
@Data
public abstract class Commando {


    private  boolean alive;
    public  Commando(){
        System.out.println(getClass().getSimpleName() + " was started " + isAlive());
    }
}
