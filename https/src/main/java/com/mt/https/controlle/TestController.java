package com.mt.https.controlle;

import com.mt.https.utils.SDKClinet;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * author: liqm
 * 2019-11-27
 */
@RequestMapping(value = "/user")
@RestController
public class TestController {

    @GetMapping(value = "/get")
    public void test() {
        try {
            SDKClinet.ssl1();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
