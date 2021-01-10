package org.example.hydra;

import org.example.hydra.configurator.ColorANSI;
import org.example.hydra.configurator.InjectProperty;
import org.example.hydra.configurator.Odino4ka;

@Odino4ka
public class HydraCommanderImpl implements HydraCommander {
    @InjectProperty("superWeapon")
    private String weapon;

    @Override
    public void command() {
        System.out.println(ColorANSI.ANSI_GREEN.getColor() +
                "All agents arm themself with " +
                weapon + "  =>" +
                this.getClass().getSimpleName()+
                ColorANSI.ANSI_RESET.getColor());
    }
}
