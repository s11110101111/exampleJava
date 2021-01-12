package org.example.hydra;

import org.example.hydra.configurator.ColorANSI;
import org.example.hydra.configurator.InjectByType;

public class SecretWarrior extends Agent implements HydraAgent {

    {
        this.setHealth(400);
        this.setRealName("Tony Masters");
        this.setName("Taskmaster");
        this.setOrganization("Hydra");
        System.out.println(ColorANSI.YELLOW.fillColor(
                "Created agent ") + super.getName());
    }

    @InjectByType
    private Weapon weapon;

    SecretWarrior() {
    }

    SecretWarrior(Weapon weapon) {
        System.out.println(ColorANSI.RED.fillColor(
                "create arent with weapon ") + super.getName());
    }

    @Override
    public boolean recruitAgent() {
        System.out.println(
                getName() + ColorANSI.RED.fillColor(" Recruiting new agents.") + "  " +
                        this.getClass().getSimpleName());
        return false;
    }

    @Override
    public boolean sabotage() {
        System.out.println(
                getName() + ColorANSI.RED.fillColor(" Sabotaged Destroy") + "  " +
                        this.getClass().getSimpleName());
        return false;
    }

    @Override
    public void attack(TargetOfAttack target) {
        sabotage();
        weapon.shoot(target);


        System.out.println(getName() + ColorANSI.RED.fillColor(
                " Bang Bang Im Kill all. ") +
                this.getClass().getSimpleName());
        System.out.println(getName() + ColorANSI.RED.fillColor(" My health -)" + "  " +
                getRemainderOfHealth()));
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
