package com.tsingyun.hpvm.collect.server;

import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by zhangzl on 2017/2/7.
 */
@Component
public class DataCollectListener {

    @RabbitListener(queues = "hpvm.data")
    @RabbitHandler
    public void process(@Payload String foo) {
        System.out.println(new Date() + ": " + foo + "hpvm.data");
    }

    @RabbitListener(queues = "hpvm.data.B")
    @RabbitHandler
    public void processB(@Payload String foo) {
        System.out.println(new Date() + ": " + foo + "hpvm.data.B");
    }

}
