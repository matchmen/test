package com.mt.designpattern.state;

/**
 * author: liqm
 * 2019-11-05
 */
public class Context {

    private State state;

    public Context(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void pushOn() {
        state.pushOn(this);
    }

    public void reject() {
        state.reject(this);
    }

}
