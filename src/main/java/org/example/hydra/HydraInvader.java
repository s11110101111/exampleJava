package org.example.hydra;

import org.example.coronadisinfector1.Announcer;

public class HydraInvader {
    private Notificator topSecretAgentsNotificator = new TopSecretAgentsNotificator();
    private HydraAgent hydraAgent = new DoctorOctopus();

    public void start(TargetOfAttack target) {

        //todo notify all agents about the beginning of the operation
        topSecretAgentsNotificator.announce("$$ Top secret $$. Hydra Start attack " + target);
        //todo prepare agents for attack
        hydraAgent.recruitAgent();
        //
        attack(target);
        topSecretAgentsNotificator.announce("finished attack who is alive ?");
        //todo

    }

    private void attack(TargetOfAttack target) {
        System.out.println("Hi Gydra! Chpok!! Chpok! Bang! Bang! attack on " + target + "  " + this.getClass().getSimpleName());
    }

}
