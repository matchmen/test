package com.mt.designpattern.strategy;

/**
 * 策略模式
 * 定义：定义一系列算法，把他们封装起来，并且是他们可以相互替换
 *
 * 例子：现在要实现一个计算器，加法和减法。我们可以设计成{@link MyCalculator}模式，后面如果我们想在实除法、乘法或更多的其他算法，我们需要继续往{@link MyCalculator}
 * 里面添加方法，那么这个计算器类就得不断的改啊改啊，每次升级算法我们都要把机器给拆开然后更改类代码，然后这个类越来越大，越来越复杂，可能发展到有几千行代码，这......
 * 妮玛......好恶心的类。好了啥也不说了，我要易维护，要易扩展，要可读性，好吧，换个思路想想,既然不能把算法给写死在这里面，那一定要把这个算法给
 * 抽象一下，把实现细节从这个类里抽离出来，独立出来成为n个策略，就当下来讲我们一共有俩个策略，一个是加法策略，一个是减法策略，他们实现的都是同一个算法接口，接收参数为
 * 操作数a，以及被操作数b，于是有了{@link Strategy}以及其实现子类加法类{@link Addition}和减法类{@link Subtraction},往后需要更多的其他算法，就类似加减法那样实现就行
 * 这就是策略模式。
 *
 * author: liqm
 * 2019-10-30
 */
public class StrategyTest {

    public static void main(String[] args) {

        Calculator calculator = new Calculator();

        calculator.setCalculator(new Addition());//接入加法

        int result = calculator.calculate(2, 4);

        System.out.println(result);

        calculator.setCalculator(new Subtraction());//接入减法

        result = calculator.calculate(5, 3);

        System.out.println(result);
    }


}
