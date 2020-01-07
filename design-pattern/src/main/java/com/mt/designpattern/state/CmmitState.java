package com.mt.designpattern.state;

/**
 * author: liqm
 * 2019-11-06
 */
public class CmmitState implements State{

    @Override
    public void pushOn(Context context) {
        System.out.println("当前状态：1");
        context.setState(new FirstState());
        System.out.println("推进后状态：2");
    }

    @Override
    public void reject(Context context) {
        System.out.println("当前状态：1");
        context.setState(new RejectState());
        System.out.println("回退后状态：0");

    }
}
