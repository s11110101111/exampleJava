package com.example.springboot.jtest.demo.singleton_anti_pattern;

import lombok.SneakyThrows;

public class RussianNdsResolver implements NdsResolver {
    private double nds;

    public RussianNdsResolver() {
        this.nds = getNdsFromCentralBank();
    }

    @SneakyThrows
    private double getNdsFromCentralBank() {
        System.out.println("Request NDS from CentroBank .... ");
    Thread.sleep(2000);
            return 0.2;
    }

    @Override
    public double getNds() {
        return nds;
    }
}
