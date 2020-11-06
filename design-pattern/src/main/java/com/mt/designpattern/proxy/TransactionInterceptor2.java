package com.mt.designpattern.proxy;

public class TransactionInterceptor2 implements Interceptor2 {

    @Override
    public Object intercept(Invocation invocation) throws Exception{
        System.out.println("------插入前置通知代码-------------");
        Object result = invocation.process();
        System.out.println("------插入后置处理代码-------------");
        return result;
    }

    @Override
    public Object plugin(Object target) {
        return MyInvocationHandler2.wrap(target,this);
    }
}
