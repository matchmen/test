package com.mt.designpattern.observer;

/**
 * author: liqm
 * 2020-02-23
 */
public class FansB extends Fans{

    public FansB(String fansName,HZWTeam hzwTeam) {
        super(fansName,hzwTeam);
    }

    @Override
    public void action() {
        System.out.println(getFansName() + "立即观看了海贼王第" + getHzwTeam().getEpisodes() + "集");
    }
}
