package com.mt.designpattern.state;

/**
 * author: liqm
 * 2019-11-06
 */
public class FirstState implements State{

    @Override
    public void pushOn(Context context) {
        System.out.println("当前状态:2");
        context.setState(new SecondState());
        System.out.println("推进后状态：3");
    }

    @Override
    public void reject(Context context) {

        System.out.println("当前状态：2");
        context.setState(new CmmitState());
        System.out.println("回退后状态：1");
    }
}
