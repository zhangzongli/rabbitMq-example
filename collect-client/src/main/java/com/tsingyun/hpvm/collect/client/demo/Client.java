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

        private RabbitTemplate rabbitTemplate;

        @Autowired
        private void setRabbitTemplate(RabbitTemplate rabbitTemplate) {
            this.rabbitTemplate = rabbitTemplate;
            rabbitTemplate.setExchange("directExchange");
        }

        @Scheduled(fixedDelay = 10000L)
        public void send() throws InterruptedException {
            rabbitTemplate.convertAndSend("abc", "hello.direct");
        }
    }
}
