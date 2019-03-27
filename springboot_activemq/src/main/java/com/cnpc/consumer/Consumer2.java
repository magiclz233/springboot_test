package com.cnpc.consumer;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer2 {

    @JmsListener( destination = "cnpc.queue",containerFactory = "queueListenerFactory")
    public void receiveQueue(String text){
        System.out.println("Consumer2 queue msg="+text);
    }

    @JmsListener(destination = "cnpc.topic",containerFactory = "topicListenerFactory")
    public void receiveTopic(String text) {
        System.out.println("Consumer2 topic msg = "+text);
    }
}
