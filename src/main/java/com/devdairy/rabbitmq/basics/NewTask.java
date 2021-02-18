package com.devdairy.rabbitmq.basics;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;

import java.nio.charset.StandardCharsets;
import java.util.*;

public class NewTask {

    private static final String TASK_QUEUE_NAME = "task_queue";

    public static void main(String[] argv) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try (Connection connection = factory.newConnection(); Channel channel = connection.createChannel()) {
            channel.queueDeclare(TASK_QUEUE_NAME,true,false,false,null);
            for(int i=0;i<new Random().nextInt(100);i++) {
                String s = new Random().nextInt(10)+""+new Random().nextInt(1000)+new Date().toString();
                List<String> list = new LinkedList<>();
                list.addAll(Arrays.asList(argv));
                list.add(s);
                String message = String.join(" ", list.stream().toArray(String[]::new));
                channel.basicPublish("", TASK_QUEUE_NAME, MessageProperties.PERSISTENT_TEXT_PLAIN, message.getBytes(StandardCharsets.UTF_8));
                System.out.println("[x] sent '" + message + "' ");
            }
        }
    }
}
