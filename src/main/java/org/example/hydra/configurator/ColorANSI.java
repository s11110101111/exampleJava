package org.example.hydra.configurator;

import lombok.Getter;

@Getter
public enum ColorANSI {
    RESET("\u001B[0m"),
    BLACK("\u001B[30m"),
    RED("\u001B[31m"),
    GREEN("\u001B[32m"),
    YELLOW("\u001B[33m"),
    BLUE("\u001B[34m"),
    PURPLE("\u001B[35m"),
    CYAN ("\u001B[36m"),
    WHITE("\u001B[37m");

    private String color;
    ColorANSI(String code){

        color = code;
    }
    public String fillColor(String message){
        return getColor()+ message + RESET.getColor();
    }

}
