package org.example.hydra;

import org.example.hydra.configurator.ApplicationContextHydra;
import org.example.hydra.weapon.PlazmaGun;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        ApplicationContextHydra contextHydra = HydraApplication.run("org.example.hydra", new HashMap<>(Map.of(
                HydraAgent.class, DoctorOctopus.class, Weapon.class, PlazmaGun.class)));
        HydraInvader hydra = contextHydra.getObject(HydraInvader.class);
        hydra.start(new ProjectSHIELD());


    }
}
