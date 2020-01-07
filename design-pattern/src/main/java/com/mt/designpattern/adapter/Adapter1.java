package com.mt.designpattern.adapter;

/**
 * 对象适配器
 * author: liqm
 * 2019-10-29
 */
public class Adapter1 implements XmlReader {

    private ReaderXml readerXml;

    public Adapter1(ReaderXml readerXml) {
        this.readerXml = readerXml;
    }

    @Override
    public void xmlReader() {
        readerXml.readerXml();
    }
}
