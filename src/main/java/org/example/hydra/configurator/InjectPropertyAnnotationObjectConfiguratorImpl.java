package org.example.hydra.configurator;

import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Field;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toMap;

public class InjectPropertyAnnotationObjectConfiguratorImpl implements ObjectConfigurator {

    private final Map<String, String> propertiesMap;

    @SneakyThrows
    public InjectPropertyAnnotationObjectConfiguratorImpl() {
        String path = ClassLoader.getSystemClassLoader().getResource("applicationHydra.properties").getPath();
        Stream<String> lines = new BufferedReader(new FileReader(path)).lines();
        propertiesMap = lines.map(line -> line.split("=")).collect(toMap(arg -> arg[0], arg -> arg[1]));
    }

    @Override
    @SneakyThrows
    public void configure(Object t) {
        Class<?> implClass = t.getClass();
        for (Field field : implClass.getDeclaredFields()) {
            InjectProperty annotation = field.getAnnotation(InjectProperty.class);
            if (annotation != null) {
                //properties by field name or annotation value if there's;
             String value =  annotation.value().isEmpty() ? propertiesMap.get(field.getName()) : propertiesMap.get(annotation.value());

                field.setAccessible(true);
                if (int.class.isAssignableFrom(field.getType())){
                 //   System.out.println( "Принт Тип поля  - " + field.getType());
                    field.set(t, Integer.valueOf(value));

                }else{
                field.set(t, value);

                }

            }

        }

    }
}
