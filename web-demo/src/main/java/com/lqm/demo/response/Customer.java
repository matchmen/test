package com.lqm.demo.response;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

/**
 * @Author Liqm
 * @Date 2020/12/1 0001
 */
@Data
public class Customer {
    @Excel(name = "手机号码",width = 20)
    private String phone;

}
