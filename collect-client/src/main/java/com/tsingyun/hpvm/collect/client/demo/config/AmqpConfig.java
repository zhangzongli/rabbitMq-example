package com.tsingyun.hpvm.collect.client.demo.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by zhangzl on 2017/2/7.
 */
@Configuration
public class AmqpConfig {
    @Bean
    MessageConverter jackson2JsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

//    @Bean
//    Queue queue() {
//        return new Queue("queue", true);
//    }
//
//    @Bean
//    TopicExchange exchange() {
//        return new TopicExchange("exchange");
//    }
//
//    @Bean
//    Binding binding(Queue queue, TopicExchange exchange) {
//        return BindingBuilder.bind(queue).to(exchange).with("routingkey");
//    }

}