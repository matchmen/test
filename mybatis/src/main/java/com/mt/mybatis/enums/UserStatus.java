package com.mt.mybatis.enums;

/**
 * author: liqm
 * 2020-01-07
 */
public enum UserStatus {

    NORMAL(10),

    DELETE(20);

    private Integer code;

    UserStatus(Integer code){
        this.code = code;
    }
}
