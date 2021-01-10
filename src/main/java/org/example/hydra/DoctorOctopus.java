package org.example.hydra;

import org.example.hydra.configurator.ColorANSI;

public class DoctorOctopus extends Agent implements HydraAgent{
    {
        this.setHealth(300);
        this.setRealName("Dr. Otto Gunther Octavius");
        this.setName("Doctor Octopus");
        this.setOrganization("Hydra");
        System.out.println(ColorANSI.ANSI_CYAN.fillColor("create arent") + super.getName());
    }


    @Override
    public boolean recruitAgent() {
        System.out.println(getName() + ColorANSI.ANSI_CYAN.fillColor(" Recruiting new agents.") + "  " + this.getClass().getSimpleName());
        return false;

    }

    @Override
    public boolean sabotage() {
        System.out.println(getName() + ColorANSI.ANSI_CYAN.fillColor(" Sabotaged Destroy") + "  " + this.getClass().getSimpleName());
        return false;

    }

    @Override
    public void attack(TargetOfAttack target) {
        recruitAgent();
        sabotage();
        System.out.println(getName() + ColorANSI.ANSI_CYAN.fillColor(" Bang Bang Im Kill all.") + "  " + this.getClass().getSimpleName());
        System.out.println(getName() + ColorANSI.ANSI_CYAN.fillColor(" My health -") + "  " + getRemainderOfHealth());
    }

    @Override
    public int getRemainderOfHealth() {
        return getHealth();
    }

    @Override
    public void setRemainderOfHealth(int health) {
        this.setHealth(health);
    }
}
