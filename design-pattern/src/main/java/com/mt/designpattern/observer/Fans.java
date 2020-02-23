package com.mt.designpattern.observer;

/**
 * author: liqm
 * 2020-02-23
 */
public abstract class Fans {//静态类，每个粉丝情况都不一样，有些收到信息后可能马上观看，有些估计还在上班，不能开小差

    private String fansName; //粉丝姓名

    private HZWTeam hzwTeam;

    public String getFansName() {
        return fansName;
    }

    public HZWTeam getHzwTeam() {
        return hzwTeam;
    }

    public void register() {
        this.hzwTeam.register(this);
    }

    public Fans(String fansName, HZWTeam hzwTeam){
        this.fansName = fansName;
        this.hzwTeam = hzwTeam;
    }

    public abstract void action();

}
