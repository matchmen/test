package com.mt.designpattern.state;

/**
 * author: liqm
 * 2019-11-05
 */
public class Routine {

    private Leave leave;

    public void setLeave(Leave leave) {
        this.leave = leave;
    }

    public void pushOn() {

        if(leave.getStatus().equals("1")){
            System.out.println("当前状态：1");
            this.leave = new Leave("2");
            System.out.println("推进后状态：2");
        } else if (leave.getStatus().equals("2")) {
            System.out.println("当前状态：2");
            this.leave = new Leave("3");
            System.out.println("推进后状态：3");
        }else if (leave.getStatus().equals("3")) {
            System.out.println("当前状态：3");
            this.leave = new Leave("4");
            System.out.println("推进后状态：4");
        }

    }

     public void reject() {
         if(leave.getStatus().equals("3")){
             System.out.println("当前状态：3");
             this.leave = new Leave("2");
             System.out.println("回退后状态：2");
         } else if (leave.getStatus().equals("2")) {
             System.out.println("当前状态：2");
             this.leave = new Leave("1");
             System.out.println("回退后状态：1");
         }else if (leave.getStatus().equals("1")) {
             System.out.println("当前状态：1");
             this.leave = new Leave("0");
             System.out.println("回退后状态：0");
         }
    }

}
