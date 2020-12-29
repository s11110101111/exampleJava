package org.example.hydra;

public class HydraCommanderImpl implements HydraCommander {

    private String weapon;

    @Override
    public void command() {
        System.out.println("All agents arm themself with " + weapon + "  =>" +  this.getClass().getSimpleName());
    }
}
