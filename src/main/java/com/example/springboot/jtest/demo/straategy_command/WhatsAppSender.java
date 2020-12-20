package com.example.springboot.jtest.demo.straategy_command;

import org.springframework.stereotype.Service;

import static com.example.springboot.jtest.demo.straategy_command.DeliveryType.SMS;
import static com.example.springboot.jtest.demo.straategy_command.DeliveryType.WHATS_APP;
@Service
public class WhatsAppSender implements MessageSender {
    @Override
    public String send(Message message) {
        String status = "WhatsApp message was sent.";
        System.out.println(status);
        return status;

    }

    @Override
    public String myCode() {

        return WHATS_APP;
    }
}
