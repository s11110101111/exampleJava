package org.example.hydra.configurator;

import org.example.hydra.HydraObjectFactory;


import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
//don't call us, we'll call you.
public class ApplicationContextHydra {
    private HydraObjectFactory factory;
    private Map<Class,Object> cachOdino4kas = new ConcurrentHashMap<>();


    public <T> T getObject(Class<T> t){
        return null;
    }
}
