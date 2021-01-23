package org.example.hydra.configurator;

import java.lang.annotation.Retention;
import static java.lang.annotation.RetentionPolicy.*;

@Retention(RUNTIME)
public @interface InjectProperty {
//int value()default 10;
        String value() default "";
}
