package com.example.springboot.jtest.demo;

import com.example.springboot.jtest.demo.singleton_anti_pattern.NdsResolver;
import com.example.springboot.jtest.demo.singleton_anti_pattern.RussianNdsResolver;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoSpringJunitBootApplicationTests {

    private NdsResolver ndsResolver;

    @BeforeEach
     void setup (){
    ndsResolver = new RussianNdsResolver();
}

    @Test
    void getNds() {
        double actual = 0.2;
        double expected = ndsResolver.getNds();
        Assert.assertEquals(expected,actual, 0.00001);
    }

}
