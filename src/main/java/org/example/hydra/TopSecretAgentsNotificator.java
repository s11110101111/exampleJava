package org.example.hydra;

public class TopSecretAgentsNotificator implements Notificator {
    private String channelLink = "$$-Top secret-$$ space channel - ";
    private  HydraCommander commander = HydraObjectFactory.getInstance().createObject(HydraCommander.class);

    @Override
    public void announce(String message) {
        System.out.println(channelLink + this);
        System.out.println(message + " tell: " + this.getClass().getSimpleName());
    }
}
