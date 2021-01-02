package org.example.hydra;

import org.example.coronadisinfector1.Announcer;

public class HydraInvader {
    private Notificator topSecretAgentsNotificator = HydraObjectFactory.getInstance().createObject(Notificator.class);
    private HydraAgent hydraAgent = HydraObjectFactory.getInstance().createObject(HydraAgent.class);

    public void start(TargetOfAttack target) {

        //todo notify all agents about the beginning of the operation
        topSecretAgentsNotificator.announce("Hydra Start attacking the " + target.getClass().getSimpleName());
        //todo prepare agents for attack
        hydraAgent.recruitAgent();
        //
        attack(target);
        topSecretAgentsNotificator.announce("finished attack who is alive ?");
        //todo

    }

    private void attack(TargetOfAttack target) {
        hydraAgent.attack(target);

        System.out.println("Hi Gydra! Chpok!! Chpok! Bang! Bang! attack the " + target
                .getClass().getSimpleName() + "\n remainder of health " + target.getRemainderOfHealth() +"  "+ this.getClass().getSimpleName());
    }

}
