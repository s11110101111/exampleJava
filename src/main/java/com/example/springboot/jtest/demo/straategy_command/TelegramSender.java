package com.example.springboot.jtest.demo.straategy_command;

import org.springframework.stereotype.Service;

import static com.example.springboot.jtest.demo.straategy_command.DeliveryType.TELEGRAM;
@Service
public class TelegramSender implements MessageSender {

    @Override
    public String send(Message message) {
        String status = "Telegram message was sent.";
        System.out.println(status);
        return status;

    }

    @Override
    public String myCode() {

        return TELEGRAM;
    }

}
