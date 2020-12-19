package com.example.springboot.jtest.demo.never_use_switch;

import lombok.Builder;

@Builder
public class   MailInfo {
    private String content;
    private String templateCode;


    public  String getContent() {
    return content;
    }

    public String getTemplateCode() {
    return templateCode;
    }

}
