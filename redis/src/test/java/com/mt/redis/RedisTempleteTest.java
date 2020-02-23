package com.mt.redis;

import com.mt.redis.entity.User;
import com.mt.redis.redisdata.RedisService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Arrays;
import java.util.List;

/**
 * author: liqm
 * 2020-02-19
 */

@SpringBootTest(classes = RedisApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@Slf4j
public class RedisTempleteTest {

    @Autowired
    private RedisService redisService;

    @Test
    public void setStr() {
        redisService.saveStr("str","First Test");
    }

    @Test
    public void getStr() {
        Object result = redisService.getStr("str");

        log.info("result:{}", result);
    }


    @Test
    public void saveObject() {
        redisService.saveObject("obj", new User("张三", 12, null));
    }

    @Test
    public void getObejct() {
        Object result = redisService.getObject("obj");

        log.info("result:{}", result);
    }

    @Test
    public void saveList() {

        List<User> users = Arrays.asList(new User("张三", 12, null),new User("李四", 12, null));

        redisService.saveList("list", users);
    }

    @Test
    public void getList() {
        Object result = redisService.getList("list");

        log.info("result:{}", result);
    }



}
