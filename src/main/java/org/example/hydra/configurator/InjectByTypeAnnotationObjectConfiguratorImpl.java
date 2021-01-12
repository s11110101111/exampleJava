package org.example.hydra.configurator;

import lombok.SneakyThrows;
import org.example.hydra.HydraObjectFactory;

import java.lang.reflect.Field;

public class InjectByTypeAnnotationObjectConfiguratorImpl implements ObjectConfigurator {



    @Override
    @SneakyThrows
    public void configure(Object t,ApplicationContextHydra context) {
        for (Field field : t.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(InjectByType.class)) {
                field.setAccessible(true);

                Object object = context.getObject(field.getType());
                field.set(t, object);

            }

        }


    }
}
