package com.mt.designpattern.adapter;

/**
 * 接口适配器
 *
 * author: liqm
 * 2019-10-29
 */
public class Adapter2 extends ReaderXml implements XmlReader{

    @Override
    public void xmlReader() {
        readerXml();
    }
}
