package org.example;

import lombok.SneakyThrows;

import java.io.ObjectInputFilter;
import java.lang.invoke.SerializedLambda;
import java.util.HashMap;
import java.util.Map;

public class ObjectFactory {
    private static final ObjectFactory ourInstance = new ObjectFactory();
    private Config config ;

    public static ObjectFactory getInstance() {
        return ourInstance;
    }

    private ObjectFactory() {
        config = new JavaConfig("org.example", new HashMap<>(Map.of(Policeman.class,AngryPolicemanImpl.class)));

    }

    @SneakyThrows
    public <T> T createObject(Class<T> type) {
        Class<? extends T> implClass = type;
        if(type.isInterface()) {
            implClass = config.getImplClass(type);
        }
         T t=implClass.getDeclaredConstructor().newInstance();

        //todo setting object t is  here



        return t;
    }
}