package com.mt.springbootapp.reponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * author: liqm
 * 2019-11-18
 */
@Data
@ToString
@AllArgsConstructor
public class Response<T> {

    private String result;

    private T msg;

}
