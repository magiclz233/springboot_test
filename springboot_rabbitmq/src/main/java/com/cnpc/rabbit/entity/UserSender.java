package com.cnpc.rabbit.entity;

import com.cnpc.model.User;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserSender {

    @Autowired
    private AmqpTemplate template;

    public void send(User user){
        System.out.println("发送者User:"+user.toString());
        this.template.convertAndSend( "object",user );
    }
}
