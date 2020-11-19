package com.lqm.demo.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @Author Liqm
 * @Date 2020/8/25 0025
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "web.config")
public class WebConfig implements Serializable {

    private String username;

    private List<String> addresses;

    private Mail defaultMail;

    private Map<String, Account> accountMap;

    private List<Mail> mails;
}
