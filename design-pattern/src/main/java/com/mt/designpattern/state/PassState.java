package com.mt.designpattern.state;

/**
 * author: liqm
 * 2019-11-06
 */
public class PassState implements State{

    @Override
    public void pushOn(Context context) {
        System.out.println("已经通过了，去玩吧");
    }

    @Override
    public void reject(Context context) {
        System.out.println("已经通过了");
    }
}
