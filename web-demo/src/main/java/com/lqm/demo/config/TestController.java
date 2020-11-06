package com.lqm.demo.config;

import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Liqm
 * @Date 2020/8/25 0025
 */
@RestController
public class TestController {

    @Autowired
    private WebConfig webConfig;

    @Autowired
    private User user;

    @GetMapping("config")
    public String config() {

        return webConfig.toString();
    }

    @GetMapping("user")
    public String user() {

        return user.toString();
    }

}
