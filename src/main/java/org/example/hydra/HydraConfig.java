package org.example.hydra;

public interface HydraConfig {
    <T> Class<?extends T> getImplClass(Class<T> interfc);
}
