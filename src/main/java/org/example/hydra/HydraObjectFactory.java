package org.example.hydra;

import lombok.SneakyThrows;
import org.example.hydra.configurator.HydraConfig;
import org.example.hydra.configurator.JavaHydraConfig;
import org.example.hydra.configurator.ObjectConfigurator;
import org.example.hydra.weapon.Gun;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class HydraObjectFactory {
    private static HydraObjectFactory ourInstance = new HydraObjectFactory();
    private HydraConfig config;
    private List<ObjectConfigurator> configurators = new ArrayList<>();
    public static HydraObjectFactory getInstance() {
        return ourInstance;
    }

    @SneakyThrows
    private HydraObjectFactory() {
        config = new JavaHydraConfig("org.example.hydra",
                new HashMap<>(Map.of(
                        HydraAgent.class, SecretWarrior.class,
                        Weapon.class, Gun.class
                )));
        for (Class<? extends ObjectConfigurator> aClass : config.getScannerIfc().getSubTypesOf(ObjectConfigurator.class)) {
            configurators.add(aClass.getDeclaredConstructor().newInstance());
        }
    }

    @SneakyThrows
    public <T> T createObject(Class<T> type) {
        Class<? extends T> implClass = type;
        if (implClass.isInterface()) {
            implClass = config.getImplClass(type);
        }
        T t = implClass.getDeclaredConstructor().newInstance();
        //todo something with t

        configurators.forEach(conf -> conf.configure(t) );
                return t;
    }
}
