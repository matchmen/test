package com.lqm.demo.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @Author Liqm
 * @Date 2020/11/23 0023
 */
@Data
public class User {

    @NotBlank(message = "name不能为空")
    private String name;

    private int age;
}
