package org.example.hydra.configurator;

import lombok.Getter;
import org.reflections.Reflections;
import java.util.Map;
import java.util.Set;

public class JavaHydraConfig implements HydraConfig {
    @Getter
    private Reflections scannerIfc;

    private Map<Class,Class> ifc2ImplClass;

    public JavaHydraConfig(String packageToScan, Map<Class, Class> ifc2ImplClass){
        this.ifc2ImplClass = ifc2ImplClass;
        this.scannerIfc = new Reflections(packageToScan);

    }



    @Override
    public <T> Class<? extends T> getImplClass(Class<T> ifc) {

        var map = ifc2ImplClass.computeIfAbsent(ifc,aClass -> {
        Set<Class<? extends T>> classes = scannerIfc.getSubTypesOf(ifc);

        if (classes.size()!=1){
            throw new RuntimeException(ifc + " has 0 or more  then one implements please update your config");
        }
        return classes.iterator().next();

        });
        return map;
    }


}
