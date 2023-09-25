package com.app.restapi.services.rabbitmq;

import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;

public class RabbitmqService {
    public static Connection connection = null;
    public static Channel channel = null;
    public static String queueName = null;

    public static void connect(String queueName) {
        try {
            ConnectionFactory factory = new ConnectionFactory();

            factory.setHost("localhost");
            factory.setPort(5672);
            factory.setPassword("passw123");
            factory.setUsername("admin");
            factory.setVirtualHost("default");

            connection = factory.newConnection();
            channel = connection.createChannel();

            channel.queueDeclare(queueName, false, false, false, null);
        } catch (Exception err) {
            err.printStackTrace();
        }
    }

    public static void sendMessage(String queueName, String message) {
        try {
            channel.basicPublish("", queueName, null, message.getBytes());
        } catch (Exception err) {
            err.printStackTrace();
        }
    }
}
