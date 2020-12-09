package com.lqm.demo.controller;

import com.lqm.demo.response.Customer;
import com.lqm.demo.utils.ExcelUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author Liqm
 * @Date 2020/12/1 0001
 */
@RestController
public class ExcelController {

    @GetMapping("down")
    public void down(HttpServletResponse response) {

        try(ServletOutputStream outputStream = response.getOutputStream()){
            String fileName = new String("用户导入模板".getBytes(StandardCharsets.UTF_8), StandardCharsets.ISO_8859_1);
            response.setContentType("multipart/form-data");
            response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx");
            List<Customer> customerList = new ArrayList<>();
            ExcelUtils.exportExcel(Customer.class, customerList, "用户信息", outputStream);
        }catch (IOException e){
        }


    }

}
