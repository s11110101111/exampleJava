package org.example.hydra;


import lombok.SneakyThrows;
import org.example.hydra.configurator.ApplicationContextHydra;
import org.example.hydra.configurator.ColorANSI;

import org.example.hydra.configurator.ObjectConfigurator;
import org.example.hydra.configurator.DeprecateProxyConfiguratorHydra;
import org.example.hydra.configurator.ProxyConfiguratorHydra;

import javax.annotation.PostConstruct;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;


public class HydraObjectFactory {

    //поместим контекст при создании
    private final ApplicationContextHydra context;


    private List<ObjectConfigurator> configurators = new ArrayList<>();
private  List<ProxyConfiguratorHydra> proxyConfigurators = new ArrayList();

    @SneakyThrows
    public HydraObjectFactory(ApplicationContextHydra context) {
        this.context = context;

        for (Class<? extends ObjectConfigurator> aClass : context.getConfig().getScannerIfc().getSubTypesOf(ObjectConfigurator.class)) {
            configurators.add(aClass.getDeclaredConstructor().newInstance());
            System.out.println(ColorANSI.YELLOW.getColor() + ">> config>> add - " + aClass.getSimpleName() + ColorANSI.RESET.getColor());
        }
        for (Class<? extends ProxyConfiguratorHydra> aClass : context.getConfig().getScannerIfc().getSubTypesOf(ProxyConfiguratorHydra.class)) {
            proxyConfigurators.add(aClass.getDeclaredConstructor().newInstance());
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

        t = wrapProxyIfNeeded (implClass, t);

        return t;
    }

    private <T> T wrapProxyIfNeeded(Class<T> implClass, T t) {
        for (ProxyConfiguratorHydra proxyConfigurator : proxyConfigurators) {
        t = (T) proxyConfigurator.replaceWithProxyIfNeeded(t, implClass);

        }
        return t;
    }

    private <T> void invokeInit(Class<T> implClass, T t) throws IllegalAccessException, InvocationTargetException {
        for (Method method : implClass.getMethods()) {
            if (method.isAnnotationPresent(PostConstruct.class)) {
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
