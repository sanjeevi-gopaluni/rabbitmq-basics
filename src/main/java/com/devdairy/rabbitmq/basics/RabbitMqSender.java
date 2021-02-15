package com.devdairy.rabbitmq.basics;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

public class RabbitMqSender {
    @Autowired
    private RabbitTemplate template;
    @Autowired
    private Queue queue;

    @Scheduled(fixedDelay = 1000,initialDelay = 500)
    public void send() {
        String message = "hello world";
        this.template.convertAndSend(queue.getName(),message);
        System.out.println(" [x] Sent' "+ message+"' ");
    }
}