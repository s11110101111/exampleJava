package org.example.hydra;

public class AgentImpl extends Agent {

    {
        this.setRealName("Pfil Colson");
        this.setName("Colson");
        this.setOrganization("SHIELD");
        System.out.println("create arent" + super.getName());
    }
    @Override
    public boolean recruitAgent() {
        return false;
    }

    @Override
    public boolean sabotage() {
        return false;
    }

    @Override
    public void attack() {

    }
}