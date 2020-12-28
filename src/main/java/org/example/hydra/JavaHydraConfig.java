package org.example.hydra;

import org.reflections.Reflections;

import java.util.Set;

public class JavaHydraConfig implements HydraConfig {

    private Reflections scanner;
    public JavaHydraConfig(String packageToScan){
        this.scanner = new Reflections(packageToScan);
    }

    @Override
    public <T> Class<? extends T> getImplClass(Class<T> ifc) {
        Set<Class<? extends T>> classes = scanner.getSubTypesOf(ifc);
        if (classes.size()!=1){
            throw new RuntimeException(ifc + "has 0 or more  then one implements");
        }
        return classes.iterator().next();
    }
}
