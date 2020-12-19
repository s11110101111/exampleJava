package com.example.springboot.jtest.demo.never_use_switch;

import org.springframework.stereotype.Component;

@Component
public class EmailCallBackMailGenerator implements MailGenerator {
    @Override
    public String generate(MailInfo mailInfo) {
        return mailInfo.getContent() +"\n don't call EmailCallBack mail.";
    }

    @Override
    public String getMyCode() {
        return "2";
    }
}

