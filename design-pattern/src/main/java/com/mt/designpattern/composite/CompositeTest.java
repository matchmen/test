package com.mt.designpattern.composite;

/**
 * 组合模式
 * 定义:组合模式（Composite Pattern）将对象组合成树形结构以表示“部分-整体”的层次结构。组合模式使得用户可以使用一致的方法操作单个对象和组合对象。
 *
 * 例子：以系统文件目录为例，我们知道，系统文件从根目录开始分支，下面可以包含文件夹或者文件，文件夹下面可以继续存放子文件夹或文件，而文件则属于“叶子”节点，
 * 下面不再有延续分支。不管三七二十一，我们笼统地把他们都抽象成”节点“。
 *
 * 现在我们开始构建程序
 * 定义一个抽象节点类{@link Node}，拥有节点名称属性，添加子节点的抽象方法，两个实现类，文件夹{@link Folder}、文件{@link File},文件夹可以添加子节点，文件不行
 *
 * 为了在视角上展示出目录结构关系，我们在{@link Node}加一个目录层级属性
 *
 * author: liqm
 * 2019-12-05
 */
public class CompositeTest {

    public static void main(String[] args) {

        //创建=根节点:D盘,当然，这是一个文件夹,存放文件夹folder1、folder2，文件file1.txt,folder1存放file2.txt，file3.txt
        Node nodeD = new Folder("D盘");
        nodeD.setLevel(0);
        Node folder1 = new Folder("folder1");
        nodeD.add(folder1);

        folder1.add(new File("file2.txt"));
        folder1.add(new File("file3.txt"));

        Node folder2 = new Folder("folder1");
        nodeD.add(folder2);
        nodeD.add(new File("file1.txt"));

        folder1.show();

    }



}
