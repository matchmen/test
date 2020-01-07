package com.mt.designpattern.template;

/**
 * author: liqm
 * 2019-11-06
 */
public abstract class AbstractTemplate {


    public abstract void buy();

    public abstract void clean();

    public abstract void cut();

    public abstract void cook();

    /**
     * 主体结构
     * 声明为final是为了不让子类自己实现
     */
    public final void execute() {
        buy();
        clean();
        cut();
        cook();
    }

}
