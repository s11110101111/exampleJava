package com.example.springboot.jtest.demo.Lazy_singleton;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class Schwarzenegger {
   @Autowired
   @Lazy
    private Rocket rocketLauncher;

   @EventListener(ContextRefreshedEvent.class)
   public  void start(){
       System.out.println(rocketLauncher.getClass());
        if (aliensLess100()) {
            beatWithLog();
        } else {
            rocketLauncher.hit();
        }

    }

    private void beatWithLog() {
        System.out.println("Hit with a log  Bam! Bam!!!");
    }

    private boolean aliensLess100() {
        return true;
    }
}
