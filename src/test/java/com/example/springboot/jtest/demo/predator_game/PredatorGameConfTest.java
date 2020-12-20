package com.example.springboot.jtest.demo.predator_game;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;



@RunWith(SpringRunner.class)
@ContextConfiguration(classes = MockConf.class)
public class PredatorGameConfTest {
    @Autowired
    private Billy commando;
    @Autowired
    private Predator predator;
    @Test
    public void setPredatorKillNotDutch(){
        predator.fight(commando);
        Assert.assertFalse(commando.isAlive());
    }

}