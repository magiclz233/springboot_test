package com.cnpc.rabbit.fanout;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "fanout1")
public class FanoutReceiver1 {

    @RabbitHandler
    public void process(String str){
        System.out.println("接收者1："+str);
    }
}
