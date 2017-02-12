package com.tsingyun.hpvm.collect.client.demo;

import org.springframework.amqp.rabbit.core.RabbitMessagingTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
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
        private RabbitMessagingTemplate rabbitMessagingTemplate;

        @Scheduled(fixedDelay = 1000L)
        public void send() {
            this.rabbitMessagingTemplate.convertAndSend("exchange", "", "hello123");

            // TODO: 2017/2/9 多个多列绑定交换器暂未实现
//            this.rabbitMessagingTemplate.convertAndSend("exchange1", "hpvm.data", 456);
            
            
//            this.rabbitTemplate.convertAndSend("hpvm.data1", "hello1");
//            this.rabbitTemplate.convertAndSend("hpvm.data", new TestModel("hello", "world"));
//            System.out.println(this.rabbitTemplate.convertSendAndReceive("hpvm.data", 100));
        }
    }
}
