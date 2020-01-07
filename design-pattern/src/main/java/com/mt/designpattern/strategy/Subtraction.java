package com.mt.designpattern.strategy;

/**
 * author: liqm
 * 2019-10-31
 */
public class Subtraction implements Strategy{
    @Override
    public int calculate(int a, int b) {
        return a - b;
    }
}
