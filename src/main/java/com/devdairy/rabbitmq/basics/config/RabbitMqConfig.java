package com.devdairy.rabbitmq.basics.config;

import com.devdairy.rabbitmq.basics.RabbitMqReceiver;
import com.devdairy.rabbitmq.basics.RabbitMqSender;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile({"tut1", "hello-world"})
@Configuration
public class RabbitMqConfig {
    @Bean
    public Queue hello() {
        return new Queue("hello");
    }
    @Bean
    @Profile("receiver")
    public RabbitMqReceiver receiver(){
        return new RabbitMqReceiver();
    }
    @Bean
    @Profile("sender")
    public RabbitMqSender sender(){
        return new RabbitMqSender();
    }
}
