package com.mt.designpattern.composite;

/**
 * author: liqm
 * 2019-12-05
 */
public class File extends Node{

    public File(String nodeName) {
        super(nodeName);
    }

    @Override
    public void add(Node node) {
        System.out.println( "添加节点！");
    }

    public void show(){
        super.show();
    }

}
