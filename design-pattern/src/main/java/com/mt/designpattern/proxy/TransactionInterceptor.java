package com.mt.designpattern.proxy;

public class TransactionInterceptor implements Interceptor{
    @Override
    public void intercept() {

        System.out.println("------后置通知------");

    }
}
