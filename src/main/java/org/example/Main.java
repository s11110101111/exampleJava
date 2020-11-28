package org.example;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
    //    CoronaDisinfector cD = ObjectFactory.getInstance().createObject(CoronaDisinfector.class);
        ApplicationContext context = Application.run("org.example", new HashMap<>(Map.of(Policeman.class, AngryPolicemanImpl.class)));
        CoronaDisinfector cD = context.getObject(CoronaDisinfector.class);
        cD.start( new Room());
    }
}
