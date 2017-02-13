package com.tsingyun.hpvm.collect.client.demo;

import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitMessagingTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * Created by zhangzl on 2017/2/7.
 */
@Configuration
@EnableScheduling
public class Client {
    @Bean
    public Sender mySender() {
        return new Sender();
    }

    public class Sender {

        @Autowired
        private RabbitTemplate rabbitTemplate;

        @Autowired
        private Jackson2JsonMessageConverter converter;

        @Scheduled(fixedDelay = 1000L)
        public void send() {
            sendToOneKey();
            sentToMapkeyWhereAll();
        }

        public void sendToOneKey() {
            MessageProperties properties = new MessageProperties();
            properties.setContentType("application/json");
            properties.setHeader("a","1");
            rabbitTemplate.setExchange("headersExchange");
            rabbitTemplate.send("", converter.toMessage("hello.headers.one.key", properties));
        }

        public void sentToMapkeyWhereAll() {
            MessageProperties properties = new MessageProperties();
            properties.setContentType("application/json");
            properties.setHeader("b","2");
            rabbitTemplate.setExchange("headersExchange");
            rabbitTemplate.send("", converter.toMessage("hello.headers.mapkey.whereAll", properties));
        }
    }
}
