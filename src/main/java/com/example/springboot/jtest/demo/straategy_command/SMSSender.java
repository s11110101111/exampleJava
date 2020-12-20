package com.example.springboot.jtest.demo.straategy_command;


import org.springframework.stereotype.Service;

import static com.example.springboot.jtest.demo.straategy_command.DeliveryType.SMS;

@Service
public class SMSSender implements MessageSender {
    @Override
    public String send(Message message) {
        String status = "SMS message was sent.";
        System.out.println(status);
        return status;

    }

    @Override
    public String myCode() {

        return SMS;
    }
}
