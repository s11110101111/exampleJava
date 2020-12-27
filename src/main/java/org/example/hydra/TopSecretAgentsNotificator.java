package org.example.hydra;

public class TopSecretAgentsNotificator implements Notificator {
    private String topSecretLabel;
    @Override
    public void announce(String message) {
        System.out.println(topSecretLabel);
        System.out.println(message + " tell: " + this.getClass().getSimpleName());
    }
}
