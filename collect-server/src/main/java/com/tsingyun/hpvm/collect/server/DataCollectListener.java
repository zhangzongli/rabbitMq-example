package com.tsingyun.hpvm.collect.server;

import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by zhangzl on 2017/2/7.
 */
@Component
@RabbitListener(queues = "queue")
public class DataCollectListener {

    @RabbitHandler
//    @RabbitListener(bindings = @QueueBinding(value = @Queue(value = "queue"), exchange = @Exchange(value = "exchange")))

    public void process(@Payload String foo) {
        System.out.println(new Date() + ": " + foo);
    }

//    @RabbitHandler
//    public void process(@Payload TestModel model) {
//        System.out.println(model.toString());
//    }

    @RabbitHandler
    public String process(@Payload Integer value) {
        return value.toString();
    }
}
