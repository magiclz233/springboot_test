package com.cnpc.config;

import com.cnpc.producer.Producer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.rule.OutputCapture;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SampleActiveMqTests {

    @Autowired
    private Producer producer;

    /**
     *  OutputCapture 是 Spring Boot 提供的一个测试类，
     *  它能捕获 System.out 和 System.err 的输出，我们可
     *  以利用这个特性来判断程序中的输出是否执行。
     */
    public OutputCapture outputCapture = new OutputCapture();

    @Test
    public void sendSimpleQueueMessage() throws InterruptedException {
        for (int i=0;i<100;i++){
            this.producer.sendQueue( "你们的哥哥来了！"+i );
        }

        Thread.sleep( 1000L );
    }

    @Test
    public void sendSimpleTopicMessage() throws InterruptedException {
        for (int i=0;i<100;i++){
            this.producer.sendTopic("你们的哥哥来了"+i);
        }
        Thread.sleep(1000L);
    }


}
