package com.mt.designpattern.state;

/**
 * author: liqm
 * 2019-11-06
 */
public interface State {

    public void pushOn(Context context);

    public void reject(Context context);

}
