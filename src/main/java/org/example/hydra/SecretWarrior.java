package org.example.hydra;

public class SecretWarrior extends Agent {
    {
        this.setRealName("Tony Masters");
        this.setName("Taskmaster");
        this.setOrganization("Hydra");
        System.out.println("create arent" + super.getName());
    }

    @Override
    public boolean recruitAgent() {
        System.out.println(getName()+ " Recruiting new agents." + "  "+this.getClass().getSimpleName());
        return false;
    }

    @Override
    public boolean sabotage(){
        System.out.println(getName()+ " Sabotaged Destroy" + "  "+this.getClass().getSimpleName());
        return false;
    }

    @Override
    public void attack() {
        recruitAgent();
        sabotage();
        System.out.println(getName()+ " Bang Bang Im Kill all." + "  "+this.getClass().getSimpleName());
    }
}
