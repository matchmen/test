package com.lqm.manage;

import javax.xml.stream.events.Characters;
import java.io.UnsupportedEncodingException;
import java.util.Base64;

/**
 * IntelliJ IDEA
 * Author:Liqm
 * Date:23/7/23 3:17 PM
 */
public class Base64Util {

    /**
     * Base64加密
     */
    public static String base64Encrypt(String var) {
        try {
            return Base64.getEncoder().encodeToString(var.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("Base encrypt exception!");
        }
    }

    /**
     * Base 64解密
     * @param str
     * @return
     */
    public static String base64Decrypt(String str) {
        try {
            return new String(Base64.getDecoder().decode(str),"UTF-8");
        } catch (Exception e) {
            throw new RuntimeException("Base decode exception!");
        }
    }




    public static void main(String[] args) {

        String str = "柬埔寨之旅";
        // base64 加解密
        String base64Encrypt = base64Encrypt(str);
        System.out.println("base64Encrypt:" + base64Encrypt + ",length:" + base64Encrypt.length());
        System.out.println("base64Decrypt:" + base64Decrypt(base64Encrypt));




    }
}
