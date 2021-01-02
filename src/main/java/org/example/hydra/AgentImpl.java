package org.example.hydra;

public class AgentImpl extends Agent {

    {
        this.setRealName("Pfil Colson");
        this.setName("Colson");
        this.setOrganization("SHIELD");
        System.out.println("create arent" + super.getName());
    }


    @Override
    public int getRemainderOfHealth() {
        return 0;
    }

    @Override
    public void setRemainderOfHealth(int health) {

    }
}