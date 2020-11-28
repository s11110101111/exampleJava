package org.example;

import net.sf.cglib.proxy.Enhancer;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DeprecatedHandlerProxyConfiguratorImpl implements ProxyConfigurator {
    @Override
    public Object replaceWithProxyIfNeeded(Object t, Class implClass) {
        if (implClass.isAnnotationPresent(Deprecated.class)) {

            if (implClass.getInterfaces().length == 0) {
                return Enhancer.create(implClass, (net.sf.cglib.proxy.InvocationHandler) (proxy, method, args) -> getInvocationHandlerLogic(t, method,args, "******** what are you doing, freak !! no methods cglib!!"));
            }

            return Proxy.newProxyInstance(implClass.getClassLoader(), implClass.getInterfaces(), (proxy, method, args) -> getInvocationHandlerLogic(t, method, args,"******** what are you doing, freak !!"));
        } else {
            return t;

        }


    }

    private Object getInvocationHandlerLogic(Object t, Method method, Object[] args, String s) throws IllegalAccessException, InvocationTargetException {
        System.out.println(s);
        return method.invoke(t, args);
    }
}
