package org.example.hydra;

import org.example.hydra.configurator.InjectProperty;

public class HydraCommanderImpl implements HydraCommander {
    @InjectProperty("superWeapon")
    private String weapon;

    @Override
    public void command() {
        System.out.println("All agents arm themself with " + weapon + "  =>" +  this.getClass().getSimpleName());
    }
}
