package com.mt.designpattern.proxy;

public class Test {
    public static void main(String[] args) {

        HelloService target = new HelloServiceImpl();

        Interceptor2 transactionInterceptor = new TransactionInterceptor2();
        //把事务拦截器插入到目标类中
        target = (HelloService) transactionInterceptor.plugin(target);

        target.seyHello();



    }


}
