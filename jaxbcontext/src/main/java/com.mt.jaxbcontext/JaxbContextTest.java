package com.mt.jaxbcontext;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * xml 与 Java对象互转
 * author: liqm
 * 2020-01-08
 */
public class JaxbContextTest {

    public static void main(String[] args) throws JAXBException {

        Student student = new Student();

        student.setUsername("张三");
        List<Classs> classsList = new ArrayList<Classs>();
        Classs classs1 = new Classs("语文","10001");
        Classs classs2 = new Classs("数学","10002");
        classsList.add(classs1);
        classsList.add(classs2);
        student.setClasss(classsList);

        System.out.println("单个实体转换。");
        System.out.println("单个实体转换。classs1:" + classs1);
        System.out.println("object to xml:" + objToXml(classs1));
        System.out.println("xml to object:" + xmlToObj( objToXml(classs1),Classs.class));

        System.out.println();
        System.out.println("含List的实体转换");
        System.out.println("student:" + student);
        System.out.println("object to xml:" + objToXml(student));
        System.out.println("xml to object:" + xmlToObj( objToXml(student),Student.class));




    }


    public static String objToXml(Object object) throws JAXBException {

        JAXBContext context = JAXBContext.newInstance(object.getClass());

        Marshaller marshaller = context.createMarshaller();

        //Marshaller.JAXB_FORMATTED_OUTPUT 决定是否在转换成xml时同时进行格式化（即按标签自动换行，否则即是一行的xml）
        //Marshaller.JAXB_ENCODING xml的编码方式
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT , false);

        marshaller.setProperty(Marshaller.JAXB_ENCODING , "UTF-8");

        StringWriter writer = new StringWriter();

        marshaller.marshal(object , writer);

        return writer.toString();
    }

    public static <T> T xmlToObj(String xmlStr,Class<T> clazz) throws JAXBException {

        JAXBContext context = JAXBContext.newInstance(clazz);

        Unmarshaller unmarshaller = context.createUnmarshaller();

        return (T)unmarshaller.unmarshal(new StringReader(xmlStr));
    }

}
