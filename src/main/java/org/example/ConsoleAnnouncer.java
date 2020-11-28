package org.example;

public class ConsoleAnnouncer implements Announcer{
    @InjectByType
    private Recommendator recommendator;

    @Override
    public void announce(String msg) {
        System.out.println(msg);
        recommendator.recommend();
    }
}
