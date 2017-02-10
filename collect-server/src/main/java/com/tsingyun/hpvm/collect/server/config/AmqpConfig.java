package com.tsingyun.hpvm.collect.server.config;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
        return new Queue("hpvm.data");
    }

    @Bean
    public Queue fooQueue1() {
        return new Queue("hpvm.data1");
    }

    @Bean
    public Queue queue() {
        return new Queue("queue");
    }

    @Bean
    public Queue queueA() {
        return new Queue("queueA");
    }

    @Bean
    public Queue queueB() {
        return new Queue("queueB");
    }

    @Bean
    public Queue queueC() {
        return new Queue("queueC");
    }

    @Bean
    public Queue queue1() {
        return new Queue("routingkey");
    }
}

