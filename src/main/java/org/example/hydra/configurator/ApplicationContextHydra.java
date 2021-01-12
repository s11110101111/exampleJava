package org.example.hydra.configurator;

import lombok.Getter;
import lombok.Setter;
import org.example.hydra.HydraObjectFactory;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

//don't call us, we'll call you.

public class ApplicationContextHydra {
    // кешируем синглтоны для последующего использования
    @Setter
    private HydraObjectFactory factory;

    private Map<Class,Object> cachOdino4kas = new ConcurrentHashMap<>();
    @Getter
    private HydraConfig config;

   public ApplicationContextHydra(HydraConfig config){

       this.config= config;
    }

    public <T> T getObject(Class<T> type){
        Class<? extends T> implClass = type;
        // проверим если такой объект в кеше уже then we  return it
        if(cachOdino4kas.containsKey(type)){
            return (T) cachOdino4kas.get(type);
         }
        if (implClass.isInterface()) {
            //если наш объект - интерфейс идем в конфиг за  реализацией
            implClass = config.getImplClass(type);
        }
        // если нет создаем его
            T t= factory.createObject(implClass);
        // проверим если класс анотирован для кеширования (синглтон) put in cache
if (implClass.isAnnotationPresent(Odino4ka.class)){
    cachOdino4kas.put(type,t);
}
        return t;
    }
}
