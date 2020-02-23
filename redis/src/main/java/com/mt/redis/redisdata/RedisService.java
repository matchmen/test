package com.mt.redis.redisdata;

import com.mt.redis.entity.User;
import org.redisson.client.RedisClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * author: liqm
 * 2020-02-19
 */
@Component
public class RedisService {

    @Autowired
    private RedisTemplate redisTemplate;


    public void saveStr(String key, String value) {

        redisTemplate.opsForValue().set(key, value,10L, TimeUnit.MINUTES);
    }

    public Object getStr(String key) {

        return redisTemplate.opsForValue().get(key);
    }

    public void saveObject(String key, User value) {

        redisTemplate.opsForValue().set(key, value);
    }


    public Object getObject(String key) {

        return redisTemplate.opsForValue().get(key);
    }

    public Object getList(String key) {

        return redisTemplate.opsForValue().get(key);
    }

    public void saveList(String key, List<User> value) {

        redisTemplate.opsForValue().set(key, value);
    }




}
