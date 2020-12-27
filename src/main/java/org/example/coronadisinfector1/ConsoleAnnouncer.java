package org.example.coronadisinfector1;

public class ConsoleAnnouncer implements Announcer{
    @InjectByType
    private Recommendator recommendator;

    @Override
    public void announce(String msg) {
        System.out.println(msg);
        recommendator.recommend();
    }
}
