package com.example.springboot.jtest.demo.never_use_switch;

import com.github.javafaker.Faker;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MailProducer {
    @Autowired
    private  final MailSender mailSender;
    @Autowired
    private  final Faker faker;

  //  @EventListener(ContextRefreshedEvent.class)
    public void start(){
        System.out.println("Producer go go...\n"+faker.chuckNorris().fact());
    }
    @Scheduled(fixedDelay = 1000)
    public void generateMail(){
        MailInfo mailInfo = MailInfo.builder()
                .content(faker.chuckNorris().fact())
                .templateCode(String.valueOf(faker.random().nextInt(3)+1))
                .build();
        mailSender.send(mailInfo);
    }

}
