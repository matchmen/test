package com.mt.rabbitmq.producer;

import com.mt.rabbitmq.ConnectionUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;

/**
 * author: liqm
 * 2019-11-15
 */
public class ChannelManager {

    private static Connection connection;

    public ChannelManager() {
        this.connection = ConnectionUtils.getConnection();
    }

    public static Channel createChannel(String exchangeName,String routingKey,String queueName,String exchangeType) {

        Channel channel = null;
        try {
            channel = connection.createChannel();
            channel.exchangeDeclare(exchangeName, exchangeType, true);
            channel.queueDeclare(queueName, true, false, false, null).getQueue();
            channel.queueBind(queueName, exchangeName, routingKey);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return channel;
    }

}
