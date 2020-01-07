package com.mt.designpattern.decorator;

/**
 * author: liqm
 * 2019-12-04
 */
public class FacLlift extends Decorator{

    public FacLlift(Showable showable) {
        super(showable);
    }

    @Override
    public void show() {
        showable.show();
        System.out.println("瘦脸");
    }


}
