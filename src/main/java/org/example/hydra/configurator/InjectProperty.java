package org.example.hydra.configurator;

import java.lang.annotation.Retention;
import static java.lang.annotation.RetentionPolicy.*;

@Retention(RUNTIME)
public @interface InjectProperty {
    String value() default "";
}
