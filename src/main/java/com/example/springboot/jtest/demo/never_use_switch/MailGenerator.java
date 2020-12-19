package com.example.springboot.jtest.demo.never_use_switch;

import org.springframework.beans.factory.annotation.Autowired;

public interface MailGenerator {
    String generate(MailInfo mailInfo);
    String getMyCode();
    //
    @Autowired
    default  void registerMyself(MailSender mailSender){
    mailSender.register(getMyCode(),this);

}

}
