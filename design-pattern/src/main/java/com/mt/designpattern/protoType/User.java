package com.mt.designpattern.protoType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.*;

/**
 *
 * author: liqm
 * 2019-10-17
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Cloneable ,Serializable{

    private String name;

    private String cerNo;

    private String address;

    private Integer age;

    private User user;

    /**
     * 浅复制
     * @return
     * @throws CloneNotSupportedException
     */
    @Override
    protected User clone() throws CloneNotSupportedException {
        return (User)super.clone();
    }

    /**
     * 深复制
     * 注意需要被深复制的类必须实现Serializable接口
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public User deepClone() throws IOException, ClassNotFoundException {

        /**
         * 写入当前对象二进制流
         */
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(this);

        /**
         * 写出当前对象二进制流
         */
        ByteArrayInputStream bis = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        ObjectInputStream objectInputStream = new ObjectInputStream(bis);
        return (User) objectInputStream.readObject();

    }


}
