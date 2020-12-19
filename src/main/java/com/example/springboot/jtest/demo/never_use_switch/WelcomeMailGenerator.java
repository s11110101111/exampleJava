package com.example.springboot.jtest.demo.never_use_switch;

import org.springframework.stereotype.Component;

@Component
public class WelcomeMailGenerator implements MailGenerator {
    @Override
    public String generate(MailInfo mailInfo) {
        return  mailInfo.getContent() + "\n Welcome mail.";

    }

    @Override
    public String getMyCode() {
        return "1";
    }
}
