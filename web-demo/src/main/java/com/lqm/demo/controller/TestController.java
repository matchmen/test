package com.lqm.demo.controller;

import com.lqm.demo.request.TestRequest;
import com.lqm.demo.response.Result;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * @Author Liqm
 * @Date 2020/11/17 0017
 */
@Slf4j
@Validated
@RestController
public class TestController {

    /**
     * 1.非对象类型参数校验
     * 1）需要在Controller方法上添加注解Validated,然后在接口方法上加javax.validation包下的注解
     * 2）Long、Integer不能使用@NotBlank注解，否则报错：HV000030: No validator could be found for constraint 'javax.validation.constraints.NotBlank' validating type 'java.lang.Integer 需要使用@NotNull;
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
     * 1.2 注解@RequestParam的使用
     */

    /**
     * 1.2.1 @RequestParam + GET，接受参数形势：
     * 1) URL拼接，如  http://localhost:8080/splitPath?id=1&code=1222&age=
     * 2) Body传输，
     *    Content-Type：multipart/form-data;
     *
     */
    @GetMapping("requestParamGet")
    public Result splitPath(@NotNull(message = "id不能为空") @RequestParam("id") Integer id,
                            @NotBlank(message = "code不能为空") @Length(min = 2,max = 5,message = "长度必须在2~5之间") @RequestParam("code") String code,
                            @NotNull(message = "年龄不能为空") @Max(value = 120, message = "age不能大于120") @Min(value = 1,message = "age不能小于0") @RequestParam(name = "age",defaultValue = "1") int age) {

        return Result.success();
    }

    /**
     * 1.2.2 @RequestParam + POST，接受参数形势：
     * 1) URL拼接，如  http://localhost:8080/splitPath?id=1&code=1222&age=
     * 2) Body传输，
     *    1)Content-Type：multipart/form-data; 参数形势：Content-Disposition: form-data; name="id" 2
     *    2)Content-Type：application/x-www-form-urlencoded;  参数形势：id=2&code=22&age=1
     *    3)
     *
     */
    @PostMapping("requestParamPost")
    public Result splitPathForRequestBody(@NotNull(message = "id不能为空") @RequestParam("id") Integer id,
                            @NotBlank(message = "code不能为空") @Length(min = 2,max = 5,message = "长度必须在2~5之间") @RequestParam("code") String code,
                            @NotNull(message = "年龄不能为空") @Max(value = 120, message = "age不能大于120") @Min(value = 1,message = "age不能小于0") @RequestParam(name = "age",defaultValue = "1") int age) {

        return Result.success();
    }

    /**
     * 2.RequestBody的使用
     */

    /**
     * 2.1 @Validated+其他验证注解
     */

    @PostMapping("objectRequestBody")
    public Result objectRequestBody(@RequestBody @Validated TestRequest request) {

        log.info("request:{}", request);

        return Result.success();
    }


}
