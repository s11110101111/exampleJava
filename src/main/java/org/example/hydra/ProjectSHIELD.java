package org.example.hydra;

public class ProjectSHIELD implements TargetOfAttack {
    private int health=1000;

    @Override
    public int getRemainderOfHealth() {
        return health;
    }

    @Override
    public void setRemainderOfHealth(int health) {
        this.health= health < 0 ? 0 : health;

    }
}
