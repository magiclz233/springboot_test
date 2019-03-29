package com.cnpc.rabbit.many;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "neo")
public class MReceiver1 {

    @RabbitHandler
    public void c(String neo){
        System.out.println("接收者1111111："+neo);
    }
}
