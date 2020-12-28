package org.example.hydra;

import lombok.SneakyThrows;
import org.example.coronadisinfector1.Config;

public class HydraObjectFactory {
    private static HydraObjectFactory ourInstance = new HydraObjectFactory();
    private HydraConfig config = new JavaHydraConfig("org.example.hydra");

    public static HydraObjectFactory getInstance() {
        return ourInstance;
    }

    private HydraObjectFactory() {

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
