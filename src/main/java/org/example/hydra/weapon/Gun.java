package org.example.hydra.weapon;

import org.example.hydra.TargetOfAttack;
import org.example.hydra.Weapon;
import org.example.hydra.configurator.InjectProperty;

public class Gun implements Weapon {
    @InjectProperty
    private int damage;
    @Override
    public void shoot(TargetOfAttack target) {
        target.setRemainderOfHealth(target.getRemainderOfHealth() - damage);
    }
}

