package com.cnpc.rabbit.many;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MSender2 {

    @Autowired
    private AmqpTemplate template;

    public void send(int i){
        String context = "spirng boot neo queue2222222"+" ****** "+i;
        System.out.println("Sender2 : " + context);
        this.template.convertAndSend( "neo",context );

    }
}
