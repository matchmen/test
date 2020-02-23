package com.mt.designpattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * author: liqm
 * 2020-02-23
 */
public class HZWTeam {

    private String episodes;//集数

    public String getEpisodes() {
        return episodes;
    }

    public HZWTeam(String episodes) {
        this.episodes = episodes;
    }

    private List<Fans> fansList = new ArrayList<>();//广大粉丝

    public void register(Fans fans ) {//粉丝通过该方法把自己的信息添加到粉丝列表
        fansList.add(fans);
    }

    public void release() {
        System.out.println("海贼王更新到第" + episodes);
        notice();
    }

    public void notice() {//动漫更新通知粉丝
        fansList.stream().forEach(fans -> {
            fans.action();
        });
    }


}
