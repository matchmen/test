package com.lqm.manage;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * IntelliJ IDEA
 * Author:Liqm
 * Date:23/7/23 3:47 PM
 */
public class UrlUtil {

    /**
     * URL参数加密
     * @param val
     * @return
     */
    public static String encrypt(String val) {
        try {
            return URLEncoder.encode(val, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("URL Encrypt Exception");
        }
    }

    public static String decrypt(String val) {
        try {
            return URLDecoder.decode(val, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("URL Encrypt Exception");
        }
    }


    public static void main(String[] args) {
        String str = "wd=重活";

        System.out.println("encrypt:" + encrypt(str));
        System.out.println("decrypt:" + decrypt(encrypt(str)));

    }


}
