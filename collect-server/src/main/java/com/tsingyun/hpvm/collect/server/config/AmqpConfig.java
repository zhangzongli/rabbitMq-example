package com.tsingyun.hpvm.collect.server.config;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sound.midi.Receiver;

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
    public Queue fooQueue() {
        return new Queue("hpvm.data",true);
    }

//    @Bean
//    public Queue fooQueue1() {
//        return new Queue("hpvm.data1", true);
//    }

//    @Bean
//    ConnectionFactory connectionFactory(){
//        CachingConnectionFactory cachingConnectionFactory = new CachingConnectionFactory();
//        cachingConnectionFactory.setHost("localhost");
//        cachingConnectionFactory.setUsername("guest");
//        cachingConnectionFactory.setPassword("guest");
//        return cachingConnectionFactory;
//    }
//
//    @Bean
//    SimpleMessageListenerContainer container(ConnectionFactory connectionFactory) {
//        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
//        container.setConnectionFactory(connectionFactory);
//        container.setQueueNames("hpvm.data");
//        return container;
//    }
}

