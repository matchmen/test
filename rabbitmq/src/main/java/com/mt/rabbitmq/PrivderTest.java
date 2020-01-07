package com.mt.rabbitmq;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * author: liqm
 * 2019-11-15
 */
public class PrivderTest {

    private static String USERNAME = "guest";
    private static String PASSWORD = "guest";
    private static String ADDRESS = "localhost";
    private static Integer PORT = 5672;

    public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {

        ConnectionFactory factory = new ConnectionFactory();

        factory.setUsername(USERNAME);
        factory.setPassword(PASSWORD);
        factory.setVirtualHost("test") ;
        factory.setHost(ADDRESS);
        factory.setPort(PORT) ;
        Connection conn = factory.newConnection();
        Channel channel = conn.createChannel();

        //String exchangeName = "20191220-exchange";
        String exchangeName = "fanout-exchange1";
        String routingKey = "20191220-routingKey";
        String queueName = "20191220-queue";
        channel.exchangeDeclare(exchangeName, "fanout", false);
        //channel.queueDeclare(queueName, true, false, false, null).getQueue();
        channel.addReturnListener(new ReturnListener() {
            @Override
            public void handleReturn(int replyCode, String replyText, String exchange, String routingKey, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String returnMsg = new String(body);
                System.out.println(returnMsg);
            }
        });
        while (true) {

            channel.basicPublish(exchangeName, "'", true, null, "RabbitMQ学习".getBytes());
            Thread.sleep(10000L);

        }

    }


}
