package com.mt.designpattern.observer;

/**
 * 观察者模式
 * 定义：观察者模式又称订阅发布模式，订阅发布模式这个名词貌似一听就知道这是个什么东西了，定义对象之间的一种一对多的依赖关系，
 * 当一个对象的状态发生变化时，其他依赖于它的对象都能得到通知并被动做点什么。
 *
 * 例子：海贼王动漫为例，喜欢看的朋友基本都跟上了更新节奏，每个星期天总务1点左右更新一集，想必大家给我一样，20分钟不到的视频，要
 * 等一个星期，饥渴难耐啊。现在呢，海贼王动漫团队为了满足广大海贼王的粉丝，加快更新节奏，只要完成一集就立刻发布出来，这个时间就
 * 不确定了，周一到周日，0点到24点，让粉丝每个一会去查一下？太麻烦了。然后呢动漫团队想出了一个办法，让粉丝们注册一个账号，只要动
 * 漫发布，就立即通过账号通知大家，粉丝收到通知就可以及时观看了。现在我们观察者模式用代码实现出来。首先定义海贼王团队类
 * {@link HZWTeam},拥有收集粉丝、更新海贼王以及通知粉丝的功能,然后定义抽象粉丝类{@link Fans},拥有注册为海贼王粉丝和观看海贼
 * 王的功能
 *
 *
 * author: liqm
 * 2020-02-23
 */
public class ObserverTest {


    public static void main(String[] args) {

        //海贼王Team
        HZWTeam hzwTeam = new HZWTeam("945");

        Fans fansa = new FansA("张三", hzwTeam);//张三
        fansa.register();//注册为粉丝

        Fans fansc = new FansB("王五", hzwTeam);
        fansc.register();//注册为粉丝

        Fans fansb = new FansB("李四", hzwTeam);
        fansb.register();

        //海贼王更新
        hzwTeam.release();

    }



}
