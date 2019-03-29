package com.cnpc.rabbit.many;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MSender1 {

    @Autowired
    private AmqpTemplate template;

    public void send(int i){
        String context = "spirng boot neo queue111111"+" ****** "+i;
        System.out.println("Sender1 : " + context);
        this.template.convertAndSend( "neo",context );

    }
}
