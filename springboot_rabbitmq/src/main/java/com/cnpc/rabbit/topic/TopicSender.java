package com.cnpc.rabbit.topic;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TopicSender {

    @Autowired
    private AmqpTemplate template;

    public void send() {
        String context = "所有的 message";
        System.out.println("Sender : " + context);
        this.template.convertAndSend("exchange", "topic.1", context);
    }

    public void send1(){
        String context = "这里是message";
        System.out.println("发送者："+context);
        this.template.convertAndSend("exchange","topic.message",context);
    }

    public void send2(){
        String context = "这里是messages";
        System.out.println("发送者："+context);
        this.template.convertAndSend("exchange","topic.messages",context);
    }
}
