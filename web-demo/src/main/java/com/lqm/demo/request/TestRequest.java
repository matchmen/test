package com.lqm.demo.request;

import lombok.Data;
import lombok.ToString;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author Liqm
 * @Date 2020/11/23 0023
 */
@Data
@ToString
public class TestRequest implements Serializable{

    @NotBlank(message = "username不能为空")
    private String username;

    @NotNull(message = "users不能为空")
    @Size(max = 1, message = "users大小不能超过1")
    private List<User> users;

    @Valid
    private User user;

}
