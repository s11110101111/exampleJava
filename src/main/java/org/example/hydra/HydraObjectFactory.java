package org.example.hydra;

import lombok.SneakyThrows;
import org.example.coronadisinfector1.Config;

import java.util.HashMap;
import java.util.Map;

public class HydraObjectFactory {
    private static HydraObjectFactory ourInstance = new HydraObjectFactory();
    private HydraConfig config ;

    public static HydraObjectFactory getInstance() {
        return ourInstance;
    }

    private HydraObjectFactory() {
      config=  new JavaHydraConfig("org.example.hydra" ,new HashMap<>(Map.of(HydraAgent.class,DoctorOctopus.class)));
    }
    @SneakyThrows
    public <T> T createObject(Class<T> type) {
        Class<? extends T> implClass = type;
        if (implClass.isInterface()) {
            implClass = config.getImplClass(type);
        }
        T t= implClass.getDeclaredConstructor().newInstance();
        //todo something with t
        return t;
    }
}
