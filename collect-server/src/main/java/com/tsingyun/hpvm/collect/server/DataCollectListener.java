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

    @RabbitListener(bindings = @QueueBinding(value = @Queue(value = "hpvm.data", durable = "false", autoDelete = "false"), exchange = @Exchange(value = "exchange", durable = "false", type = "topic")))
    @RabbitHandler
    public void process(@Payload String foo) {
        System.out.println(new Date() + ": " + foo);
    }

    // TODO: 2017/2/9 多个多列绑定交换器暂未实现
//    @RabbitListener(bindings = @QueueBinding(value = @Queue(value = "hpvm.data"), exchange = @Exchange(value = "exchange1")))
//    @RabbitHandler
//    public void process1(@Payload Integer foo) {
//        System.out.println(new Date() + ": " + foo);
//    }

//    @RabbitHandler
//    public void process(@Payload TestModel model) {
//        System.out.println(model.toString());
//    }

//    @RabbitHandler
//    public String process(@Payload Integer value) {
//        return value.toString();
//    }
}
