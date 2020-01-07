package com.mt.designpattern.composite;

/**
 * author: liqm
 * 2019-12-05
 */
public abstract class Node {

    private String nodeName;

    private int level;

    public String getNodeName() {
        return nodeName;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }

    public Node(String nodeName) {
        this.nodeName = nodeName;
    }

    public abstract void add(Node node);

    public void show(){
        for (int i = 0; i <= this.getLevel(); i++) {
            System.out.print("  ");
        }
        System.out.println(this.getNodeName());
    }

}
