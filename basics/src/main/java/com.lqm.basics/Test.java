package com.lqm.basics;

import com.alibaba.fastjson.JSON;
import jdk.nashorn.internal.parser.JSONParser;
import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Liqm
 * @Date 2020/11/20 0020
 */
public class Test {

    public static void main(String[] args) {

        String str = "{\"value\": 12345678901234567890}";

        System.out.println(Long.MAX_VALUE);
        System.out.println("12345678901234567890");

        System.out.println(JSON.parseObject(str, MyObject.class));
        System.out.println(JSON.toJSONString(JSON.parseObject(str, MyObject.class)));
    }

    @ToString
    @Data
    static class MyObject {
        private Long value;
    }
}
