package com.example.springboot.jtest.demo.predator_game;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = MockConf.class)
public class PredatorGameConfTest {
    @Autowired
    private Commando billy;
    @Autowired
    private Predator predator;
    @Test
    public void setPredatorKillNotDutch(){
        predator.fight(billy);
        Assert.assertFalse(billy.isAlive());
    }

}