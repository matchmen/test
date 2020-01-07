package com.mt.rabbitmq.producer;


import com.rabbitmq.client.Channel;

/**
 * author: liqm
 * 2019-11-15
 */
public class SendMessage {

    private Channel channel;

    public SendMessage(Channel channel) {
        this.channel = channel;
    }

    public void send(String message) {

        //channel.basicPublish(message);


    }



}
