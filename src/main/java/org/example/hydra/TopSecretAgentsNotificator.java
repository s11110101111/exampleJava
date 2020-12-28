package org.example.hydra;

public class TopSecretAgentsNotificator implements Notificator {
    private String channelLink = "$$-Top secret-$$ space channel - ";

    @Override
    public void announce(String message) {
        System.out.println(channelLink + this);
        System.out.println(message + " tell: " + this.getClass().getSimpleName());
    }
}
