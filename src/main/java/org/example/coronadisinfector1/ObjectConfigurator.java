package org.example.coronadisinfector1;
//типа bean postprocessor
public interface ObjectConfigurator {
    void configure(Object t,ApplicationContext context);
}
