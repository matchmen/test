package com.mt.designpattern.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * author: liqm
 * 2019-12-05
 */
public class Folder extends Node{

    List<Node> nodes = new ArrayList<>();

    public Folder(String nodeName) {
        super(nodeName);
    }

    @Override
    public void add(Node childNode) {
        childNode.setLevel(this.getLevel() + 1);
        nodes.add(childNode);
    }

    public void show() {
        super.show();
        for (Node node:nodes) {
            node.show();
        }
    }
}
