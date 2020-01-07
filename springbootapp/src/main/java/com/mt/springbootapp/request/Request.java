package com.mt.springbootapp.request;

import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

/**
 * author: liqm
 * 2019-10-25
 */
@Data
@ToString
public class Request {

    @NotBlank(message = "用户名不能为空")
    private String username;

    @NotBlank(message = "密码不能为空")
    private String password;

}
