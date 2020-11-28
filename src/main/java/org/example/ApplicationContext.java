package org.example;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class  ApplicationContext {
    @Setter
    private ObjectFactory objectFactory;
    @Getter
    private Config config;
    private Map<Class, Object> cache = new ConcurrentHashMap<>();

    public ApplicationContext(Config config) {
        this.config = config;
    }

    public <T> T getObject(Class<T> type){
        Class<? extends T> implClass = type;
    if (cache.containsKey(type)){
        return (T) cache.get(type);
    }

        if (type.isInterface()) {
            implClass = config.getImplClass(type);
        }
        T t  = objectFactory.createObject(implClass);

        if (implClass.isAnnotationPresent(Singleton.class)){
            cache.put(type,t);

        }
        return t;
    }
}
