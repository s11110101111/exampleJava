package org.example.hydra;

import org.example.hydra.configurator.ApplicationContextHydra;
import org.example.hydra.configurator.ColorANSI;
import org.example.hydra.configurator.JavaHydraConfig;
import java.util.Map;

public  class HydraApplication {
 /*   config = new JavaHydraConfig("org.example.hydra",
                                         n));
*/

    public static ApplicationContextHydra run(String packageToScan, Map<Class, Class> inf2ImplClass) {
        // передаем мапу с конфигурацией интерфейс - имплиментация
        JavaHydraConfig config = new JavaHydraConfig(packageToScan, inf2ImplClass);
        ApplicationContextHydra context = new ApplicationContextHydra(config);
        HydraObjectFactory factory = new HydraObjectFactory(context);
// todo настроить не ленивые синглтоны
        context.setFactory(factory);
        System.out.println(ColorANSI.YELLOW.fillColor("Created context App Hydra."));
        return context;
    }

    ;
}
