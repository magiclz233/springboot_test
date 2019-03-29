package com.cnpc.rabbit.entity;

import com.cnpc.model.User;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "object")
public class UserReceiver {

    @RabbitHandler
    public void c(User user){
        System.out.println("接收者User:"+user);
    }
}
