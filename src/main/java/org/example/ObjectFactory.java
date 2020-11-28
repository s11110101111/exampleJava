package org.example;

import lombok.SneakyThrows;
import java.util.ArrayList;
import java.util.List;

public class ObjectFactory {
    private static final ObjectFactory ourInstance = new ObjectFactory();
    private List<ObjectConfigurator> configurators = new ArrayList<>();
    private Config config;
    private final ApplicationContext context;

    public static ObjectFactory getInstance() {
        return ourInstance;
    }

    @SneakyThrows
    public ObjectFactory(ApplicationContext context) {
        this.context = context;
        for (Class<? extends ObjectConfigurator> aClass : context.getConfig().getScanner().getSubTypesOf(ObjectConfigurator.class)) {
            configurators.add(aClass.getDeclaredConstructor().newInstance());

        }
    }

    @SneakyThrows
    public <T> T createObject(Class<T> implClass) {

        T t = implClass.getDeclaredConstructor().newInstance();

        //todo setting object t is  here
        configurators.forEach(objectConfigurator -> objectConfigurator.configure(t, context));


        return t;
    }
}