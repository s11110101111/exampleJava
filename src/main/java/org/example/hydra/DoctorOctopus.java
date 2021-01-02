package org.example.hydra;

public class DoctorOctopus extends Agent implements HydraAgent{
    {
        this.setHealth(300);
        this.setRealName("Dr. Otto Gunther Octavius");
        this.setName("Doctor Octopus");
        this.setOrganization("Hydra");
        System.out.println("create arent" + super.getName());
    }


    @Override
    public boolean recruitAgent() {
        System.out.println(getName() + " Recruiting new agents." + "  " + this.getClass().getSimpleName());
        return false;

    }

    @Override
    public boolean sabotage() {
        System.out.println(getName() + " Sabotaged Destroy" + "  " + this.getClass().getSimpleName());
        return false;

    }

    @Override
    public void attack(TargetOfAttack target) {
        recruitAgent();
        sabotage();
        System.out.println(getName() + " Bang Bang Im Kill all." + "  " + this.getClass().getSimpleName());
        System.out.println(getName() + " My health -" + "  " + getRemainderOfHealth());
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
