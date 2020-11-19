package com.mt.mythread.atomic;

/**
 * @Author Liqm
 * @Date 2020/11/11 0011
 */
public class AtomicObj {

    private String name;

    private String name2;

    public AtomicObj(String name, String name2) {
        this.name = name;
        this.name2 = name2;
    }

    @Override
    public String toString() {
        return "AtomicObj{" +
                "name='" + name + '\'' +
                ", name2='" + name2 + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName2() {
        return name2;
    }

    public void setName2(String name2) {
        this.name2 = name2;
    }
}
