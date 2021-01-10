package org.example.hydra;

public class Main {

    public static void main(String[] args) {
        HydraInvader hydra = HydraObjectFactory.getInstance().createObject(HydraInvader.class);
        hydra.start(new ProjectSHIELD());


    }
}
