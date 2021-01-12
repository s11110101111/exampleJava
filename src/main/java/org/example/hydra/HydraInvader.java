package org.example.hydra;



import org.example.hydra.configurator.ColorANSI;
import org.example.hydra.configurator.InjectByType;
import org.example.hydra.configurator.InjectProperty;


public class HydraInvader {
    @InjectByType
    private Notificator topSecretAgentsNotificator ;
    @InjectByType
    private HydraAgent hydraAgent;

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

        System.out.println(ColorANSI.RED.fillColor("Hi Gydra! Chpok!! Chpok! Bang! Bang! attack the '") + target
                .getClass().getSimpleName() + "' \nTarget's Remaining health = " +
                target.getRemainderOfHealth() +"  "+ this.getClass().getSimpleName() );
    }

}
