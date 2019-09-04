package com.mt.jdk18stream;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * author: liqm
 * 2019-08-29
 */
@Data
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class User{

    private Integer id;

    private String username;

    private Integer age;

    private String address;

}
