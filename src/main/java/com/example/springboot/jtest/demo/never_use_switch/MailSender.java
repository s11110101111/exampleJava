package com.example.springboot.jtest.demo.never_use_switch;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toMap;

@Service
public class MailSender {
//делаем авто регистрацию по факту в мапу
    private Map<String, MailGenerator> map = new HashMap<>();
  //
   public void register(String code,MailGenerator mailGenerator){
       map.put(code, mailGenerator);
       System.out.println("set code template   "+code);

       if (map.get(code)!=null) {

       }
   }
    public void send(MailInfo mailInfo) {
        String code = mailInfo.getTemplateCode();

        MailGenerator mailGenerator = map.get(code);
        if (mailGenerator == null){
            throw new UnsupportedOperationException(code + "unsupported template.");
        }
        String html = mailGenerator.generate(mailInfo);
        sendMail(html);
    }
@SneakyThrows
    private void sendMail(String html) {
    System.out.println("Send mail...");
         Thread.sleep(1000);
        System.out.println(html);
    }
}
