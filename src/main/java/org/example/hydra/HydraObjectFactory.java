package org.example.hydra;

import lombok.SneakyThrows;
import org.example.hydra.configurator.ApplicationContextHydra;
import org.example.hydra.configurator.ColorANSI;

import org.example.hydra.configurator.ObjectConfigurator;

import javax.annotation.PostConstruct;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;


public class HydraObjectFactory {

    //поместим контекст при создании
    private final ApplicationContextHydra context;

    private List<ObjectConfigurator> configurators = new ArrayList<>();


    @SneakyThrows
    public HydraObjectFactory(ApplicationContextHydra context) {
        this.context = context;

        for (Class<? extends ObjectConfigurator> aClass : context.getConfig().getScannerIfc().getSubTypesOf(ObjectConfigurator.class)) {
            configurators.add(aClass.getDeclaredConstructor().newInstance());
            System.out.println(ColorANSI.YELLOW.getColor() + ">> config>> add - " + aClass.getSimpleName() + ColorANSI.RESET.getColor());
        }
    }

    @SneakyThrows
    public <T> T createObject(Class<T> implClass) {
        //todo something with t
        T t = create(implClass);
        configure(t);
        //todo проводим инт методы по аннотации @PostConstruct

        invokeInit(implClass, t);
        return t;
    }

    private <T> void invokeInit(Class<T> implClass, T t) throws IllegalAccessException, InvocationTargetException {
        for (Method method : implClass.getMethods()) {
         if(method.isAnnotationPresent(PostConstruct.class)){
             method.invoke(t);
         }
        }
    }

    private <T> void configure(T t) {
        configurators.forEach(conf -> conf.configure(t, context));
    }

    private <T> T create(Class<T> implClass) throws InstantiationException, IllegalAccessException, java.lang.reflect.InvocationTargetException, NoSuchMethodException {
        T t = implClass.getDeclaredConstructor().newInstance();
        return t;
    }
}
