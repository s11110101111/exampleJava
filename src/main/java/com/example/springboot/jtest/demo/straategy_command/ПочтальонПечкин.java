package com.example.springboot.jtest.demo.straategy_command;

import ch.qos.logback.core.joran.conditional.IfAction;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class ПочтальонПечкин {

    private Map<String, MessageSender> map = new HashMap<>();
    //private Message testMess =  new Message("005","Content message hehe","to Vasia");

    @GetMapping("/send")
    public Map<String, MessageSender> getSenders(){
        return map;
    }

    @PostMapping("/send")
    public String distribute(@RequestBody Message message) {
        String type = message.getDistributionType();
        MessageSender sender = map.get(type);
        if (sender == null) {
            return "not supported " + type;
        }
        return sender.send(message);
    }

    public void register(String myCode, MessageSender sender) {
        map.put(myCode, sender);
    }


}
