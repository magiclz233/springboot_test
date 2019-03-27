package com.cnpc.consumer;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    @JmsListener( destination = "cnpc.queue",containerFactory = "queueListenerFactory")
    public void receiveQueue(String text){
        System.out.println("Consumer queue msg="+text);
    }

    @JmsListener( destination = "cnpc.topic",containerFactory = "topicListenerFactory")
    public void receiveTopic(String text){
        System.out.println("Consumer topic msg="+text);
    }
}
