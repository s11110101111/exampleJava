package org.example.hydra;

import org.example.hydra.configurator.ColorANSI;
import org.example.hydra.configurator.InjectByType;

public class TopSecretAgentsNotificator implements Notificator {
    private String channelLink = ColorANSI.PURPLE.fillColor("$$-Top secret-$$ space channel - ")
            ;
    @InjectByType
    private  HydraCommander commander;

    @Override
    public void announce(String message) {
        System.out.println(channelLink + this);
        System.out.println(message + " tell: " + this.getClass().getSimpleName());
        commander.command();
    }
}
