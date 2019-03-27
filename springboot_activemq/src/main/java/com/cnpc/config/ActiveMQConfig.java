package com.cnpc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;

import javax.jms.ConnectionFactory;

/**
 * Spring Boot 集成 ActiveMQ 的项目默认只支持队列或者广播中的一种，通过配置项
 * spring.jms.pub-sub-domain 的值来控制，true 为广播模式，false 为队列模式，
 * 默认情况下支持队列模式。如果需要在同一项⽬目中既支持队列模式也支持广播模式，
 * 可以通过 DefaultJmsListenerContainerFactory 创建自定义的 JmsListenerContainerFactory 实例，
 * 之后在 @JmsListener 注解中通过 containerFactory 属性引用它。
 * 分别建两个自定义的 JmsListenerContainerFactory 实例，通过 pubSubDomain
 * 来控制是支持队列模式还是广播模式.
 * 然后在消费者接收的方法中，指明使用 containerFactory 接收消息
 * 改造完成之后，再次执行队列和广播的测试方法，就会发现项目同时支持了两种类型的消息收发
 */
@Configuration
@EnableJms
public class ActiveMQConfig {

    @Bean("queueListenerFactory")
    public JmsListenerContainerFactory<?> queueListenerFactory(ConnectionFactory connectionFactory){
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        factory.setConnectionFactory( connectionFactory );
        factory.setPubSubDomain( false );
        return factory;
    }

    @Bean("topicListenerFactory")
    public JmsListenerContainerFactory<?> topicListenerFactory(ConnectionFactory connectionFactory){
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        factory.setConnectionFactory( connectionFactory );
        factory.setPubSubDomain( true );
        return factory;
    }
}
