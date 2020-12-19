package com.example.springboot.jtest.demo.never_use_switch;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

import java.util.Locale;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class ConfigTest {

    @Test
    void faker() {

        Faker faker1 = new Faker(new Locale("ru"), new Random(24));
        Faker faker2 = new Faker(new Locale("ru"), new Random(24));
        System.out.println(faker1.name().firstName());
        System.out.println(faker2.name().firstName());
        assertEquals(faker1.name().firstName(), faker2.name().firstName());
    }
}