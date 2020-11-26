package org.example;

public class Main {
    public static void main(String[] args) {
        CoronaDisinfector cD = ObjectFactory.getInstance().createObject(CoronaDisinfector.class);
        cD.start( new Room());
    }
}
