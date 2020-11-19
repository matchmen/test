package com.lqm.basics;

import lombok.Data;

/**
 * @Author Liqm
 * @Date 2020/11/18 0018
 */
@Data
public class BaseClazz {

    private Integer a;

    public static void main(String[] args) {
        BaseClazz baseClazz = new BaseClazz();
        test(baseClazz.getA());
    }

    public static void test(int a) {
        System.out.println(a);
    }


}
