package org.example;

public class AngryPolicemanImpl implements Policeman {
    @InjectByType
    Recommendator recommendator;
    @Override
    public void makePeopleLeaveRoom()
    {
        System.out.println(recommendator.getClass());
        System.out.println("i'm angry cop. kill all.");
    }
}
