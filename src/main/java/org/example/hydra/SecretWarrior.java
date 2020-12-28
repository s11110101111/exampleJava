package org.example.hydra;

public class SecretWarrior implements HydraAgent {
    private String realName = "Tony Masters";
    private String name = "Taskmaster";

    @Override
    public boolean recruitAgent() {
        System.out.println(name+ " Recruiting new agents." + "  "+this.getClass().getSimpleName());
        return false;
    }

    @Override
    public boolean sabotage(){
        System.out.println(name+ " Sabotaged Destroy" + "  "+this.getClass().getSimpleName());
        return false;
    }

    @Override
    public void attack() {
        recruitAgent();
        sabotage();
        System.out.println(name+ " Bang Bang Im Kill all." + "  "+this.getClass().getSimpleName());
    }
}
