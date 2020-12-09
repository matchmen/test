package com.mt.designpattern.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * author: liqm
 * 2019-10-21
 */
public class SingletonTest {

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?> singletonClass = Singleton.class;
        Constructor<?> constructor = singletonClass.getDeclaredConstructor(null);
        constructor.setAccessible(true);
        Object newInstance = constructor.newInstance(null);
        Singleton singleton = Singleton.getLazyInstance();

        System.out.println(newInstance == singleton);

    }


}
