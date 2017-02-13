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

//    @Bean
//    RabbitAdmin rabbitAdmin(ConnectionFactory connectionFactory) {
//        return new RabbitAdmin(connectionFactory);
//    }
//
//    @Bean
//    ConnectionFactory connectionFactory(){
//        CachingConnectionFactory cachingConnectionFactory = new CachingConnectionFactory();
//        cachingConnectionFactory.setHost("localhost");
//        cachingConnectionFactory.setUsername("guest");
//        cachingConnectionFactory.setPassword("guest");
//        return cachingConnectionFactory;
//    }

    @Bean
    MessageConverter jackson2JsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

//    @Bean
//    public MappingJackson2MessageConverter jackson2Converter() {
//        MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
//        return converter;
//    }

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


//    @Bean
//    FanoutExchange fanoutExchange() {
//        FanoutExchange fanoutExchange = new FanoutExchange("fanoutExchange");
//        return fanoutExchange;
//    }

//    @Bean
//    TopicExchange exchange() {
//        TopicExchange topicExchange = new TopicExchange("topicExchange");
//        return topicExchange;
//    }

    @Bean
    HeadersExchange headersExchange() {
        HeadersExchange headersExchange = new HeadersExchange("headersExchange");
        return headersExchange;
    }

//    @Bean
//    DirectExchange directExchange() {
//        DirectExchange directExchange = new DirectExchange("directExchange");
//        return directExchange;
//    }

    // TODO: 2017/2/9 多个多列绑定交换器暂未实现
//    @Bean
//    DirectExchange exchange1() {
//        DirectExchange directExchange = new DirectExchange("exchange1");
//        return directExchange;
//    }

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

    // TODO: 2017/2/9 多个多列绑定交换器暂未实现
//    @Bean
//    Binding bindingExchangeMessage1(Queue queueMessage, TopicExchange exchange1, RabbitAdmin rabbitAdmin) {
//        Binding binding = BindingBuilder.bind(queueMessage).to(exchange1).with("hpvm.data");
//        rabbitAdmin.declareBinding(binding);
//        return binding;
//    }

//    @Bean
//    public RabbitTemplate rabbitTemplate() {
//        RabbitTemplate template = new RabbitTemplate(connectionFactory());
//        //The routing key is set to the name of the queue by the broker for the default exchange.
//        template.setRoutingKey("hpvm.data");
//        //Where we will synchronously receive messages from
//        template.setQueue("hpvm.data");
//        return template;
//    }
//
//    @Bean
//    public RabbitMessagingTemplate rabbitMessagingTemplate(RabbitTemplate rabbitTemplate) {
//        RabbitMessagingTemplate rabbitMessagingTemplate = new RabbitMessagingTemplate();
//        rabbitMessagingTemplate.setMessageConverter(jackson2Converter());
//        rabbitMessagingTemplate.setRabbitTemplate(rabbitTemplate);
//        return rabbitMessagingTemplate;
//    }
}