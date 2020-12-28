package org.example.hydra;

public class DoctorOctopus implements HydraAgent {
    private String realName = "Dr. Otto Gunther Octavius";
    private String name = "Doctor Octopus";
    @Override
    public boolean recruitAgent() {
        System.out.println(name+ " Recruiting new agents." + "  "+this.getClass().getSimpleName());
        return false;

    }

    @Override
    public boolean sabotage() {
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
