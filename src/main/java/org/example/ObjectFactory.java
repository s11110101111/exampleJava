package org.example;

import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.ObjectInputFilter;
import java.lang.invoke.SerializedLambda;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toMap;


public class ObjectFactory {
    private static final ObjectFactory ourInstance = new ObjectFactory();
    private Config config;

    public static ObjectFactory getInstance() {
        return ourInstance;
    }

    private ObjectFactory() {
        config = new JavaConfig("org.example", new HashMap<>(Map.of(Policeman.class, AngryPolicemanImpl.class)));

    }

    @SneakyThrows
    public <T> T createObject(Class<T> type) {
        Class<? extends T> implClass = type;
        if (type.isInterface()) {
            implClass = config.getImplClass(type);
        }
        T t = implClass.getDeclaredConstructor().newInstance();

        //todo setting object t is  here
        for (Field field : implClass.getDeclaredFields()) {
            InjectProperty annotation = field.getAnnotation(InjectProperty.class);
            String path = ClassLoader.getSystemClassLoader().getResource("application.properties").getPath();
            Stream<String> lines = new BufferedReader(new FileReader(path)).lines();
            Map<String, String> propertiesMap = lines.map(line -> line.split("=")).collect(toMap(arr -> arr[0], arr -> arr[1]));
            if (annotation != null){
                String value = annotation.value().isEmpty() ? propertiesMap.get(field.getName()) : propertiesMap.get(annotation.value());
                field.setAccessible(true);
                field.set(t,value);
            }


        }


        return t;
    }
}