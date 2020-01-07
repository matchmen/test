package com.mt.designpattern.strategy;

/**
 * author: liqm
 * 2019-10-31
 */
public class Calculator {

    private Strategy strategy;

    public void setCalculator(Strategy strategy) {
        this.strategy = strategy;
    }

    public int calculate(int a, int b) {
        return strategy.calculate(a, b);
    }

}
