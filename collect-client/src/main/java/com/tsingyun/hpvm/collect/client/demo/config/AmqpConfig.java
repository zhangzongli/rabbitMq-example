package com.tsingyun.hpvm.collect.client.demo.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitMessagingTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhangzl on 2017/2/7.
 */
@Configuration
public class AmqpConfig {

    @Bean
    MessageConverter jackson2JsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean(name = "hpvm.data")
    Queue queue() {
        Queue queue = new Queue("hpvm.data", true, false, false);
        return queue;
    }

    @Bean(name = "hpvm.data.B")
    Queue queueB() {
        Queue queue = new Queue("hpvm.data.B", true, false, false);
        return queue;
    }

    @Bean
    HeadersExchange headersExchange() {
        HeadersExchange headersExchange = new HeadersExchange("headersExchange");
        return headersExchange;
    }

    @Bean
    Binding bindingExchangeMessage(@Qualifier("hpvm.data") Queue queue, HeadersExchange exchange) {
        Binding binding = BindingBuilder.bind(queue).to(exchange).where("a").matches("1");
        return binding;
    }

    @Bean
    Binding bindingExchangeMessageB(@Qualifier("hpvm.data.B")Queue queue, HeadersExchange exchange) {
        Map<String, Object> keyMap = new HashMap<String, Object>();
        keyMap.put("b","2");
        keyMap.put("c","3");
        Binding binding = BindingBuilder.bind(queue).to(exchange).whereAll(keyMap).match();
        return binding;
    }
}