package org.example.hydra;

import org.example.hydra.configurator.ColorANSI;
import org.example.hydra.configurator.InjectProperty;
import org.example.hydra.configurator.Odino4ka;

@Odino4ka
public class HydraCommanderImpl implements HydraCommander {
    {
        System.out.println("Create HydraComander impl");
    }
    @InjectProperty("superWeapon")
    private String weapon;

    @Override
    public void command() {
        System.out.println(ColorANSI.GREEN.getColor() +
                "All agents arm themself with " +
                weapon + "  =>" +
                this.getClass().getSimpleName()+
                ColorANSI.RESET.getColor());
    }
}
