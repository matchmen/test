package com.lqm.demo.exception;

import lombok.Data;

/**
 * @Author Liqm
 * @Date 2020/11/17 0017
 */
@Data
public class ServiceException extends RuntimeException{

    private String code;

    private String message;

    public ServiceException(String code,String message) {
        this.code = code;
        this.message = message;
    }

    public ServiceException(String message) {
        this.message = message;
    }
}
