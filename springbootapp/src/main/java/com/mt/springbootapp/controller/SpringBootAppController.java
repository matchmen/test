package com.mt.springbootapp.controller;

import com.mt.springbootapp.reponse.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * author: liqm
 * 2019-10-25
 */
@Slf4j
@Controller
@RequestMapping(value = "/app")
public class SpringBootAppController {

    @Value("${server.port}")
    private String port;

    @GetMapping("/test")
    @ResponseBody
    public Response test(@RequestParam(value = "username") String usrname) {

        log.info("你好！" + usrname);

        return new Response<String>("S", "请求成功!请求处理接口:" + port);

    }
}
