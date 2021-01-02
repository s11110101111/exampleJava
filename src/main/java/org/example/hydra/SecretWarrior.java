package org.example.hydra;

public class SecretWarrior extends Agent implements HydraAgent{

    {
        this.setHealth(400);
        this.setRealName("Tony Masters");
        this.setName("Taskmaster");
        this.setOrganization("Hydra");
        System.out.println("create arent" + super.getName());
    }
    private  Weapon weapon;

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
       weapon.shoot(target);
        target.setRemainderOfHealth(target.getRemainderOfHealth() - 100);

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
