package com.cnpc.rabbit;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FanoutRabbitConfig {

    @Bean
    public Queue queueMessage1(){
        return new Queue("fanout1");
    }

    @Bean
    public Queue queueMessage2(){
        return new Queue("fanout2");
    }

    @Bean
    public Queue queueMessage3(){
        return new Queue("fanout3");
    }

    @Bean
    FanoutExchange fanoutExchange(){
        return new FanoutExchange("fanoutExchange");
    }

    @Bean
    Binding bindingExchange1(Queue queueMessage1,FanoutExchange fanoutExchange){
        return BindingBuilder.bind(queueMessage1).to(fanoutExchange);
    }

    @Bean
    Binding bindingExchange2(Queue queueMessage2,FanoutExchange fanoutExchange){
        return BindingBuilder.bind(queueMessage2).to(fanoutExchange);
    }

    @Bean
    Binding bindingExchange3(Queue queueMessage3,FanoutExchange fanoutExchange){
        return BindingBuilder.bind(queueMessage3).to(fanoutExchange);
    }
}
