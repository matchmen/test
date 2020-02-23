package com.mt.designpattern.observer;

/**
 * author: liqm
 * 2020-02-23
 */
public class FansA extends Fans{

    public FansA(String fansName,HZWTeam hzwTeam) {
        super(fansName,hzwTeam);
    }

    @Override
    public void action() {
        System.out.println(getFansName()+"在上班，不能开小差.");
    }
}