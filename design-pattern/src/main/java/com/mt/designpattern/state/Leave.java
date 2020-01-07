package com.mt.designpattern.state;

/**
 * author: liqm
 * 2019-11-06
 */
public class Leave {

    private String status;

    public Leave(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
