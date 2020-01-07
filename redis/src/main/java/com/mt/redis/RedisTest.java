package com.mt.redis;

import redis.clients.jedis.Jedis;

import java.time.LocalDate;

/**
 * author: liqm
 * 2019-12-16
 */
public class RedisTest {

    public static void main(String[] args) {

        // 构造jedis对象
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        // 向redis中添加数据
        jedis.set("name", "李大人");
        // 从redis中读取数据
        String value = jedis.get("name");

        System.out.println(value);

        // 关闭连接
        jedis.close();
    }



}
