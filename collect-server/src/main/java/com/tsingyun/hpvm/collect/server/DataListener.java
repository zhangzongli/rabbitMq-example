package com.tsingyun.hpvm.collect.server;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by zhangzl on 2017/2/7.
 */
@Component
@RabbitListener(queues = "hpvm.data1")
public class DataListener {
    @RabbitHandler
    public void process(@Payload String foo) {
        System.out.println("123" + ": " + foo);
    }
}
