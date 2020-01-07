package com.mt.designpattern.adapter;

/**
 * 适配器模式
 * 定义：把一个类的接口转换成客户端所需要的林外一种接口，从而使原接口不匹配而无法一起工作的两个类能在一起工作。
 * 要素：
 *      目标：客户端使用的特定接口；
 *      客户：使用目标接口；
 *      被适配者：一个现存的需要匹配的接口；
 *      适配器：负责将现存的接口转换成目标接口
 *
 * 例子：现在需要的xml读取接口，要求接口名称为：ReaderXml，读取方法为：xmlReader，现在有一个现成的xml读取类:ReaderXml,拥有xml读取方法：readerXml；
 *      实现不想重新再写一次xml读取的代码了，重复代码看着实在让人蓝瘦，那么适配器就派上用场了。现在就用适配器实现这个内容
 * author: liqm
 * 2019-10-29
 */
public class AdapterTest {

    public static void main(String[] args) {
        /** 接口适配器 */
        System.out.println("xxxxxxxxxxxxxxx接口适配器xxxxxxxxxxxxxxxxxxx");
        XmlReader xmlReader = new Adapter2();
        xmlReader.xmlReader();

        /** 对象适配器 */
        System.out.println("xxxxxxxxxxxxxxx对象适配器xxxxxxxxxxxxxxxxxxx");
        ReaderXml readerXml = new ReaderXml();
        XmlReader xmlReader1 = new Adapter1(readerXml);
        xmlReader1.xmlReader();

    }

}
