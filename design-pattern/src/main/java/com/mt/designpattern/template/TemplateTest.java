package com.mt.designpattern.template;

/**
 *
 * 模板方法模式
 * 定义：定义一个抽象类，在抽象类中定义了程序的主体结构或者流程，细节部分由子类实现，这就是模板方法模式。
 *
 * 例子：以炒菜为例，一般流程都是买菜、洗菜、切菜、炒菜依次进行，模板里面我们只需要定义这几个行为的顺序即可，至于怎么买什么菜、怎么洗、怎么切、怎么炒这些具体的行为
 * 留给子类实现。好了，根据模板模式定义和需求定义类{@link AbstractTemplate},这个模式过程比较简单，也容易理解，具体就不再往下了
 *
 * author: liqm
 * 2019-11-06
 */
public class TemplateTest {

    public static void main(String[] args) {

        AbstractTemplate cookMeat = new CookMeat();

        cookMeat.execute();

    }

}
