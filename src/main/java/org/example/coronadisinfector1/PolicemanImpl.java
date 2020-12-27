package org.example.coronadisinfector1;

public class PolicemanImpl implements Policeman {
    @InjectByType
    private Recommendator recommendator;

    public void init() {
        System.out.println(recommendator.getClass());
    }

    @Override
    public void makePeopleLeaveRoom() {
        System.out.println(recommendator.getClass());
        System.out.println("I'm cop! All out of here. I'll shot");
    }
}
