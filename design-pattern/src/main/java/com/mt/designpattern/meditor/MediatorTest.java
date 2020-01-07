package com.mt.designpattern.meditor;

/**
 * 中介模式
 * 定义:将多个对象之间通信的网状结构转化为星状结构，从而避免多个对象之间的相互耦合，是一种行为型的设计模式。中介者模式的思路就是加入一个中介者对象，
 * 所有对象与对象之间的通信，均通过中介者来进行，所以每个对象不再依赖其他的对象。
 *
 * 列子:比如模拟一个公司有张三、李四、王五、赵二等几个同事，需要实现他们之间的单独通话和群聊通话。这是一个很明显的网状通信的问题。
 * 张三给李四发消息问'吃饭没？李四回复'刚吃完。咋了？'张三继续说'那我们开个会。'，李四回复'好的，我通知一下其他同事'
 *
 * 现在我们需要创建几个类：
 * 学生类{@link Colleague},同事类包含一个属性，姓名，拥有登录、对个人发送消息、群发送消息和接收消息的功能；
 * 中介类{@link Mediator},主要功能是管理已经登录的同事和转发他们之间的消息；
 * 参考：https://www.imooc.com/article/25971
 * author: liqm
 * 2019-12-04
 */
public class MediatorTest {


    public static void main(String[] args) {
        //全部登录
        Colleague zhangsan = new Colleague("张三");
        zhangsan.login();
        Colleague lisi = new Colleague("李四");
        lisi.login();
        Colleague wangwu = new Colleague("王五");
        wangwu.login();
        Colleague zhaoer = new Colleague("赵二");
        zhaoer.login();

        System.out.println("------------张三李四单独聊-------------");
        zhangsan.sendMessageToOne("李四","吃饭没？");
        lisi.sendMessageToOne("张三","刚吃完。咋了？");
        zhangsan.sendMessageToOne("李四","那我们开个会。");
        lisi.sendMessageToOne("张三","好的，我通知一下其他同事");

        System.out.println("------------李四群发消息-------------");
        lisi.sendMessageToAll("大家来会议室开个会");

    }








}
