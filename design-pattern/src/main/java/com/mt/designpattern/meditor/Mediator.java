package com.mt.designpattern.meditor;


import java.util.ArrayList;
import java.util.List;

/**
 * 中介类
 * author: liqm
 * 2019-12-04
 */
public class Mediator {

    private static List<Colleague> colleagues = new ArrayList<>();

    public static void add(Colleague colleague) {
        colleagues.add(colleague);
    }

    public static void sendMsgToOne(String sendMsgClooeagueName,String receiveMsgColleagueName,String msg){

        Colleague receiveMsgColleague = colleagues.stream().filter(colleague -> receiveMsgColleagueName.equals(colleague.getName())).findFirst().get();

        receiveMsgColleague.receiveMessage(sendMsgClooeagueName,msg);

    }

    public static void sendMsgToAll(String sendMsgClooeagueName,String msg){

        colleagues.stream().filter(colleague -> !sendMsgClooeagueName.equals(colleague.getName())).forEach(colleague -> {
            colleague.receiveMessage(sendMsgClooeagueName, msg);
        });
    }



}
