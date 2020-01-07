package com.mt.rabbitmq;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.TimeoutException;

/**
 * author: liqm
 * 2019-11-15
 */
public class ConsumerTest1 {

    private static String USERNAME = "guest";
    private static String PASSWORD = "guest";
    private static String ADDRESS = "localhost";
    private static Integer PORT = 5672;

    public static void main(String[] args) throws IOException, TimeoutException {

        ConnectionFactory factory = new ConnectionFactory();

        factory.setUsername(USERNAME);
        factory.setPassword(PASSWORD);
        factory.setVirtualHost("test") ;
        factory.setHost(ADDRESS);
        factory.setPort(PORT) ;
        Connection conn = factory.newConnection();

        Channel channel = conn.createChannel();
        channel.exchangeDeclare("fanout-exchange1", "fanout");
        String queuename = channel.queueDeclare().getQueue();
        channel.queueBind(queuename, "fanout-exchange1", "");

        Consumer consumer = new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag,
                                       Envelope envelope,
                                       AMQP.BasicProperties properties,
                                       byte[] body) {

                String message = null;
                try {
                    message = new String(body,"UTF-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                System.out.println("consumerTag:" + consumerTag + ",exchange:" + envelope.getExchange() + ",route:" + envelope.getRoutingKey() + ",message:" + message);
            }

        };

        channel.basicConsume(queuename, false, consumer);

    }

}
