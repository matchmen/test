package com.mt.designpattern.decorator;

/**
 * 装饰器
 * author: liqm
 * 2019-12-04
 */
public abstract class Decorator implements Showable{

    protected Showable showable;

    public Decorator(Showable showable) {
        this.showable = showable;
    }

    @Override
    public void show() {
        showable.show();//直接掉，不做任何装饰
    }
}
