package com.mt.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * author: liqm
 * 2019-09-29
 */
public class DemoDynamicProxy implements InvocationHandler {

    private Object originObject;

    public Object bind(Object originObject){
        this.originObject = originObject;
        return Proxy.newProxyInstance(originObject.getClass().getClassLoader(), originObject.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("Hello Sir!");

        return method.invoke(originObject, args);
    }
}
