package org.example.hydra.configurator;

import net.sf.cglib.proxy.Enhancer;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DeprecateProxyConfiguratorHydra implements ProxyConfiguratorHydra {

    @Override
    public Object replaceWithProxyIfNeeded(Object t, Class implClass) {
        // cglib  вызовем через если интерфейса нет у класса
        // тогда  наш прокси отнаследуется от класса
        if (implClass.getInterfaces().length == 0) {
            // not interfaces
            return Enhancer.create(implClass, (net.sf.cglib.proxy.InvocationHandler) (proxy, method, args) ->
                    getObject(t, method, args));
        }


        if (t.getClass().isAnnotationPresent(Deprecated.class)) {
            return Proxy.newProxyInstance(t.getClass().getClassLoader(), implClass.getInterfaces(), (proxy, method, args) ->
                    getObject(t, method, args));
        } else {

            return t;
        }
    }

    private Object getObject(Object t, Method method, Object[] args) throws IllegalAccessException, InvocationTargetException {
        System.out.println(ColorANSI.CYAN.fillColor("Wath****** what the fuck is going on here...who deprecate me?"));
        System.out.println(ColorANSI.CYAN.fillColor("Deprecated " + t.getClass() + " method " + method.getName()));
        return method.invoke(t, args);
    }

}
