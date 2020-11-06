package com.mt.designpattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

public class MyInvocationHandler2 implements InvocationHandler {

    private Object target;

    private Interceptor2 interceptor;

    public MyInvocationHandler2(Object target,Interceptor2 interceptor) {
        this.target = target;
        this.interceptor = interceptor;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Invocation invocation = new Invocation(target,method,args);
        return interceptor.intercept(invocation);
    }

    public static Object wrap(Object target,Interceptor2 interceptor) {
        MyInvocationHandler2 targetProxy = new MyInvocationHandler2(target, interceptor);
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),targetProxy);
    }

}
