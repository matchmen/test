package com.lqm.demo.controller;

import com.lqm.demo.response.Result;
import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.*;

/**
 * @Author Liqm
 * @Date 2020/11/17 0017
 */
@Validated
@RestController
public class TestController {

    /**
     * 1.非对象类型参数校验
     * 需要在Controller方法上添加注解Validated,然后在接口方法上加javax.validation包下的注解
     */

    /**
     * 1.1 @PathVariable 地址类型参数校验
     */
    @GetMapping("PathVariable/{code}/{mail}")
    public Result pathVariable(@Pattern(regexp = "\\d{5}",message = "code格式不正确") @PathVariable(name = "code") String code,
                               @Pattern(regexp = "^[A-Za-z0-9]+([_\\.][A-Za-z0-9]+)*@([A-Za-z0-9\\-]+\\.)+[A-Za-z]{2,6}$",message = "mail格式不正确")
                               @PathVariable(name = "mail") String mail) {

        return Result.success();
    }

    /**
     * 1.2 问号地址拼接类型,如：path?id=1
     * 1.2.1 Long、Integer不能使用@NotBlank注解，否则报错：HV000030: No validator could be found for constraint 'javax.validation.constraints.NotBlank' validating type 'java.lang.Integer'
     *       需要使用@NotNull;
     */
    @GetMapping("splitPath")
    public Result splitPath(@NotNull(message = "id不能为空") @RequestParam("id") Integer id,
                            @NotBlank(message = "code不能为空") @Length(min = 2,max = 5,message = "长度必须在2~5之间") @RequestParam("code") String code,
                            @NotNull(message = "年龄不能为空") @Max(value = 120, message = "age不能大于120") @Min(value = 1,message = "age不能小于0") @RequestParam(name = "age",defaultValue = "1") int age) {

        return Result.success();
    }

    /**
     * 2.
     */

}
