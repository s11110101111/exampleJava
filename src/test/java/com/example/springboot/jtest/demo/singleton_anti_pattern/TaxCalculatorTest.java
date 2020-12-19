package com.example.springboot.jtest.demo.singleton_anti_pattern;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class TaxCalculatorTest {

    @Test
    void withNDS() {
        NdsResolver mock = Mockito.mock(NdsResolver.class);
        Mockito.when(mock.getNds()).thenReturn(0.2);
        double priceWithNds = new TaxCalculator(mock).withNDS(100);
        Assert.assertEquals(120,priceWithNds,0.0001);
    }
}