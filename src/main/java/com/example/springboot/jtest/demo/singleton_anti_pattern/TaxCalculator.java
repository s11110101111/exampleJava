package com.example.springboot.jtest.demo.singleton_anti_pattern;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class TaxCalculator {

    private NdsResolver ndsResolver ;
    public  double withNDS (double price){
        return ndsResolver.getNds()*price + price;
    }


}
