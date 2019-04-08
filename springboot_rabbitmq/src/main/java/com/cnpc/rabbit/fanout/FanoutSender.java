package com.cnpc.rabbit.fanout;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class FanoutSender {
    @Autowired
    private AmqpTemplate template;

    @Bean
    public void send(){
        String context = "fanout Message";
        System.out.println("发送者："+context);
        this.template.convertAndSend("fanoutExchange","",context);
    }
}
