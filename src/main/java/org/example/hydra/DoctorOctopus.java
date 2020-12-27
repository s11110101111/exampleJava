package org.example.hydra;

public class DoctorOctopus implements HydraAgent {
    @Override
    public boolean recruitAgent() {
        System.out.println("Recruiting new agents." + "  "+this.getClass().getSimpleName());
        return false;

    }

    @Override
    public boolean sabotage() {
        System.out.println("Sabotaged Destroy" + "  "+this.getClass().getSimpleName());
        return false;

    }

    @Override
    public void attack() {
       recruitAgent();
       sabotage();
       System.out.println("Bang Bang Im Kill all." + "  "+this.getClass().getSimpleName());
    }
}
