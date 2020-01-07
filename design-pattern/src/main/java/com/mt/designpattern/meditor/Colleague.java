package com.mt.designpattern.meditor;

/**
 * author: liqm
 * 2019-12-04
 */
public class Colleague {

    private String name;


    public Colleague(String name) {

        this.name = name;
    }

    public String getName() {

        return name;
    }

    public void login() {
        Mediator.add(this);
    }

    public void sendMessageToAll(String message)
    {
        Mediator.sendMsgToAll(this.name, message);
    }

    public void sendMessageToOne(String name,String message)
    {
        Mediator.sendMsgToOne(this.name, name, message);
    }



    public void receiveMessage(String sendMsgClooeagueName,String message)
    {
        System.out.println(name + ":收到了来自【" + sendMsgClooeagueName + "】的消息  -->  " + message);
    }



}
