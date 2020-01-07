package com.mt.designpattern.decorator;

/**
 * 装饰模式
 * 定义: 动态给一个对象添加一些额外的职责。
 *
 * 例子: 以网咯直播为例，打开网咯直播平台，哇！好多美女帅哥啊，😍😍😻...... 打住！不要说你只相信你的眼睛，你还真不能相信你的眼睛。来，这里就来给你解析一下这些美女帅哥。
 * 不咋丑的：哎呀！我这么漂亮，就随便画个淡装好了（其实浓妆艳抹）
 * 一般丑的：要吸引眼球，我得好好化妆，而且我还要开美颜；
 * 丑的:MMP，不行了，我得好好化妆，开美颜，瘦脸；
 * 丑的不要不要的:.......
 * 素颜？那是不可能的,都是通过多层包装装饰的。不过也有可能是素颜，除非是那个谁,好了不扯淡了。
 * 现在为了不欺骗观众，要把主播使用的方式告诉观众，做这么个需求
 * 现在需要展示这些主播的脸，我们需要考虑这些情况，
 * 1、主播素颜；2、主播化装；3、直播开美颜；4、主播开瘦脸；
 * 主播需要使用上面1种或者使用几种，随意增加方式。不可能实现 4*3*2*1 = 1000万 这么多方法吧，而且想增加个方式得换个方法？这也.....使用装饰模式吧
 * 好了既然使用装饰模式，需要定义抽象接口{@link Showable} 用于展示主播使用的方式，实现{@link Showable}的装饰抽象类{@link Decorator}，
 * {@link Decorator} 实现类化妆{@link Makeup}、美颜{@link Beauty}、瘦脸{@link FacLlift}
 *
 *
 * author: liqm
 * 2019-12-03
 */
public class DecoratorTest {
    public static void main(String[] args) {


        //只是美颜
        System.out.println("#################主播1###############");

        Showable showable = new Anchor();
        showable.show();

        System.out.println("##################主播2##############");
        //化妆
        showable = new Makeup(new Anchor());
        showable.show();

        System.out.println("##############主播3##################");
        //化妆 + 美颜
        showable = new Beauty(new Makeup(new Anchor()));
        showable.show();

    }



}
