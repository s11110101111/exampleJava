package org.example.hydra.configurator;

import org.reflections.Reflections;

public interface HydraConfig {

    <T> Class<?extends T> getImplClass(Class<T> interfc);
    Reflections getScannerIfc();
}
