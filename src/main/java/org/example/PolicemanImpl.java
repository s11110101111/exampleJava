package org.example;

public class PolicemanImpl implements Policeman {
    @InjectByType
    private Recommendator recommendator;

    @Override
    public void makePeopleLeaveRoom() {
        System.out.println(recommendator.getClass());
        System.out.println("I'm cop! All out of here. I'll shot");
    }
}
