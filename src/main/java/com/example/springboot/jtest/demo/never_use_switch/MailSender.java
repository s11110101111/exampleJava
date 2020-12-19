package com.example.springboot.jtest.demo.never_use_switch;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toMap;

@Service

public class MailSender {
//Старый вариант с @Component("1") mailGenerators . Autowired
    private Map<String, MailGenerator> map;
  //
    @Autowired
    public MailSender(List<MailGenerator> mailGenerators){
        map = mailGenerators.stream()
                .collect(Collectors.toMap(x-> x.getMyCode(),x-> x ));

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
