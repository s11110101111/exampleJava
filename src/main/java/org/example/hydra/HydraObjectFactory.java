package org.example.hydra;

import lombok.Setter;
import lombok.SneakyThrows;
import org.example.hydra.configurator.ApplicationContextHydra;
import org.example.hydra.configurator.ColorANSI;

import org.example.hydra.configurator.ObjectConfigurator;

import java.util.ArrayList;
import java.util.List;


public class HydraObjectFactory {

    //поместим контекст при создании
    private final ApplicationContextHydra context;

    private List<ObjectConfigurator> configurators = new ArrayList<>();


    @SneakyThrows
    public HydraObjectFactory(ApplicationContextHydra context) {
        this.context = context;

        for (Class<? extends ObjectConfigurator> aClass : context.getConfig().getScannerIfc().getSubTypesOf(ObjectConfigurator.class)) {
            configurators.add(aClass.getDeclaredConstructor().newInstance());
            System.out.println(ColorANSI.YELLOW.getColor() + ">> config>> add - " + aClass.getSimpleName() + ColorANSI.RESET.getColor());
        }
    }

    @SneakyThrows
    public <T> T createObject(Class<T> implClass) {

        //todo something with t
        T t = implClass.getDeclaredConstructor().newInstance();
        configurators.forEach(conf -> conf.configure(t, context));
        return t;
    }
}
