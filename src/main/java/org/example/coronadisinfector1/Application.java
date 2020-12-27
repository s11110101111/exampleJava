package org.example.coronadisinfector1;

import java.util.Map;

public class Application {
    public static ApplicationContext run(String packageToScan, Map<Class, Class> ifs2ImplClass){
        JavaConfig javaConfig = new JavaConfig(packageToScan, ifs2ImplClass);
        ApplicationContext context = new ApplicationContext(javaConfig);
        ObjectFactory objectFactory = new ObjectFactory(context);
        //todo homework init all singletonts which are not lazzy
        context.setObjectFactory(objectFactory);
        return context;

    }
}
