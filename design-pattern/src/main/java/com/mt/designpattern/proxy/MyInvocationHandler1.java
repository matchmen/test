package com.mt.designpattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

public class MyInvocationHandler1 implements InvocationHandler {

    private Object target;

    private List<Interceptor> interceptors;

    public MyInvocationHandler1(Object target,List<Interceptor> interceptors) {
        this.target = target;
        this.interceptors = interceptors;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        for (Interceptor interceptor : interceptors) {
            interceptor.intercept();
        }
        Object rs = method.invoke(target,args);
        return rs;
    }

    public static Object wrap(Object object,List<Interceptor> interceptors) {
        return Proxy.newProxyInstance(object.getClass().getClassLoader(),
                object.getClass().getInterfaces(), new MyInvocationHandler1(object, interceptors));
    }

    public static void main(String[] args) {
        List<Interceptor> interceptors = new ArrayList<>();
        interceptors.add(new LogInterceptor());
        interceptors.add(new TransactionInterceptor());
        HelloService proxyService = (HelloService) MyInvocationHandler1.wrap(new HelloServiceImpl(),interceptors);
        proxyService.seyHello();
    }


}
