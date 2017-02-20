package com.tsingyun.hpvm.collect.server;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.*;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeoutException;

/**
 * Created by zhangzl on 2017/2/7.
 */
@Component
@EnableScheduling
public class DataCollectListener {

    @Autowired
    private CachingConnectionFactory cachingConnectionFactory;

//    @RabbitListener(queues = "hpvm.data")
//    @RabbitListener(bindings = @QueueBinding(value = @Queue(value = "hpvm.data", autoDelete = "false", durable = "true"), exchange = @Exchange(value = "directExchange", durable = "true"), key = "abcd"))
//    @RabbitHandler
@Scheduled(fixedDelay = 1000L)
    public void process() throws IOException, TimeoutException {

        ConnectionFactory connectionFactory = cachingConnectionFactory.getRabbitConnectionFactory();
        Connection connection = connectionFactory.newConnection();
        Channel channel = connection.createChannel();

//        channel.exchangeDeclare("directExchange", "direct");

        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope,
                                       AMQP.BasicProperties properties, byte[] body) throws IOException {
                String message = new String(body, "UTF-8");
                System.out.println(" [x] Received '" + envelope.getRoutingKey() + "':'" + message + "'");
            }
        };

        channel.basicConsume("hpvm.data", true, consumer);

//        System.out.println(new Date() + ": " + foo + "hpvm.data");
    }

//    @RabbitListener(queues = "hpvm.data.B")
//    @RabbitHandler
//    public void processB(@Payload String foo) {
//        System.out.println(new Date() + ": " + foo + "hpvm.data.B");
//    }

}
