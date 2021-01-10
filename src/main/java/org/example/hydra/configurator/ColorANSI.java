package org.example.hydra.configurator;

import lombok.Getter;

@Getter
public enum ColorANSI {
    ANSI_RESET("\u001B[0m"),
    ANSI_BLACK("\u001B[30m"),
    ANSI_RED("\u001B[31m"),
    ANSI_GREEN("\u001B[32m"),
    ANSI_YELLOW("\u001B[33m"),
    ANSI_BLUE("\u001B[34m"),
    ANSI_PURPLE("\u001B[35m"),
    ANSI_CYAN ("\u001B[36m"),
    ANSI_WHITE("\u001B[37m");

    private String color;
    ColorANSI(String code){

        color = code;
    }
    public String fillColor(String message){
        return getColor()+ message + ANSI_RESET.getColor();
    }

}
