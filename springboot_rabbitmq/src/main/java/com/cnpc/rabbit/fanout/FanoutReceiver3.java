package com.cnpc.rabbit.fanout;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "fanout3")
public class FanoutReceiver3 {

    @RabbitHandler
    public void process(String str){
        System.out.println("接收者3："+str);
    }
}
