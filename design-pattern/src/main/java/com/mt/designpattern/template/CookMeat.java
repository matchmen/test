package com.mt.designpattern.template;

/**
 * author: liqm
 * 2019-11-06
 */
public class CookMeat extends AbstractTemplate{
    @Override
    public void buy() {

        System.out.println("买菜");

    }

    @Override
    public void clean() {
        System.out.println("洗菜");

    }

    @Override
    public void cut() {
        System.out.println("切菜");

    }

    @Override
    public void cook() {
        System.out.println("煮菜");

    }
}
