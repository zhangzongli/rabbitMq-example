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

    @Bean
    Queue queueA() {
        return new Queue("queueA", true);
    }

    @Bean
    Queue queueB() {
        return new Queue("queueB", true);
    }

    @Bean
    Queue queueC() {
        return new Queue("queueC", true);
    }

//    @Bean
//    TopicExchange exchange() {
//        return new TopicExchange("exchange");
//    }

    @Bean
    FanoutExchange exchange() {
        return new FanoutExchange("exchange");
    }

    @Bean
    Binding bindingA(Queue queueA, FanoutExchange exchange) {
        return BindingBuilder.bind(queueA).to(exchange);
    }

    @Bean
    Binding bindingB(Queue queueB, FanoutExchange exchange) {
        return BindingBuilder.bind(queueB).to(exchange);
    }

}