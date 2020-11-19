package org.example;

public class Main {
    public static void main(String[] args) {
        CoronaDisinfector cD = new CoronaDisinfector();
        cD.start( new Room());
    }
}
