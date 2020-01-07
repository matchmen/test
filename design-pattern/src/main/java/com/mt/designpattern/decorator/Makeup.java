package com.mt.designpattern.decorator;

/**
 * author: liqm
 * 2019-12-04
 */
public class Makeup extends Decorator{

    public Makeup(Showable showable) {
        super(showable);
    }

    @Override
    public void show() {
        showable.show();
        System.out.println("化妆");
    }
}
