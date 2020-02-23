package com.mt.redis.entity;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * author: liqm
 * 2019-12-16
 */
@Data
@ToString
public class User implements Serializable {

    private String name;

    private int age;

    private LocalDate birthday;

    public User(String name, int age, LocalDate birthday) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }
}
