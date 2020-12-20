package com.example.springboot.jtest.demo.straategy_command;


import org.springframework.beans.factory.annotation.Autowired;

public interface MessageSender {
    String send(Message message);

    String myCode();

    @Autowired
    default void register(ПочтальонПечкин почтальонПечкин) {
        почтальонПечкин.register(myCode(), this);
    }

}
