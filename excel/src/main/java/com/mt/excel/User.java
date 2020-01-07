package com.mt.excel;

import com.alibaba.excel.annotation.ExcelProperty;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

/**
 * author: liqm
 * 2019-12-13
 */
public class User {

    @ExcelProperty("姓名")
    private String name;
    @ExcelProperty("出生年月日")
    private LocalDate birthday;
    @ExcelProperty("年龄")
    private int age;
    @ExcelProperty("薪资")
    private BigDecimal salary;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public User(String name, LocalDate birthday, int age, BigDecimal salary) {
        this.name = name;
        this.birthday = birthday;
        this.age = age;
        this.salary = salary;
    }
}
