package com.mt.designpattern.state;

/**
 * author: liqm
 * 2019-11-06
 */
public class RejectState implements State{

    @Override
    public void pushOn(Context context) {
        System.out.println("已经拒绝了，回去上班吧");
    }

    @Override
    public void reject(Context context) {
        System.out.println("已经拒绝了。");
    }
}
