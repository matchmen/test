package com.mt.designpattern.state;

/**
 * author: liqm
 * 2019-11-06
 */
public class SecondState implements State{

    @Override
    public void pushOn(Context context) {
        System.out.println("当前状态：3");
        context.setState(new PassState());
        System.out.println("回退后状态：4");
    }

    @Override
    public void reject(Context context) {
        System.out.println("回退后状态：3");
        context.setState(new FirstState());
        System.out.println("回退后状态：2");
    }

}
