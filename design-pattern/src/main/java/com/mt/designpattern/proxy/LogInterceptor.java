package com.mt.designpattern.proxy;

public class LogInterceptor implements Interceptor{
    @Override
    public void intercept() {

        System.out.println("------前置通知------");

    }
}
