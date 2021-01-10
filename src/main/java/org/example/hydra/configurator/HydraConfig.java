package org.example.hydra.configurator;

import org.reflections.Reflections;

import java.nio.file.FileSystems;

public interface HydraConfig {

    <T> Class<?extends T> getImplClass(Class<T> interfc);
    Reflections getScannerIfc();

}
