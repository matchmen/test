package com.mt.designpattern.protoType;

import java.io.IOException;

/**
 * 原型模式
 * 定义：使用原型实例指定待创建对象的类型，并且通过复制这个原型来创建新的对象。
 *
 * author: liqm
 * 2019-10-17
 */
public class ProtoTypeTest {

    public static void main(String[] args) throws CloneNotSupportedException, IOException, ClassNotFoundException {


        User user = new User("詹姆斯", "127398", "成都", 12, new User());

        System.out.println("原始对象:" + user);

        User cloneUser = user.clone();

        System.out.println("浅复制对象:" + cloneUser);

        User deepCloneUser = user.deepClone();

        System.out.println("深复制对象:" + deepCloneUser);

        System.out.println("深浅差异：");

        System.out.println("原始对象的user属性与浅复制对象的user属性对比结果:" + (user.getUser() == cloneUser.getUser()));

        System.out.println("原始对象的user属性与深复制对象的user属性对比结果:" + (user.getUser() == deepCloneUser.getUser()));

    }

}
