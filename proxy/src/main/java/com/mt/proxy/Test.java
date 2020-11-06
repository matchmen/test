package com.mt.proxy;

/**
 * author: liqm
 * 2019-09-29
 */
public class Test {

    public static void main(String[] args) {

        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");

        Demo demo = (Demo) new DemoDynamicProxy().bind(new DemoImpl());

        demo.print();

    }


}
