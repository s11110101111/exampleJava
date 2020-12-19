package com.example.springboot.jtest.demo.never_use_switch;

import org.springframework.stereotype.Component;

@Component
public class WarningNewsMailGenerator implements MailGenerator {
    @Override
    public String generate(MailInfo mailInfo) {
        return mailInfo.getContent() + "\n Warning news mail.";
    }

    @Override
    public String getMyCode() {
        return "3";
    }
}
