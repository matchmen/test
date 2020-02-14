package com.mt.excel;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.read.builder.ExcelReaderBuilder;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * 官网：https://alibaba-easyexcel.github.io/quickstart/write.html
 * author: liqm
 * 2019-12-13
 */
public class ExcelTest {

    private static String path = "/Users/ktjr/Desktop/user.xlsx";

    public static void readExcel() {

        EasyExcel.read(path, User.class, new MyAnalysisEventListener()).sheet().doRead();


    }

    public static void onlyWriteExcel() {

        List<User> list = new ArrayList<>();
        User kebi = new User("科比", LocalDate.now(), 40, new BigDecimal(2000.01));
        User zms = new User("詹姆斯", LocalDate.now(), 34, new BigDecimal(3000.01));
        User kuli = new User("库里", LocalDate.now(), 32, new BigDecimal(3000.01));
        User dulante = new User("杜兰特", LocalDate.now(), 32, new BigDecimal(3000.01));
        list.add(kebi);
        list.add(zms);
        list.add(kuli);
        list.add(dulante);

        EasyExcel.write(path, User.class).sheet().doWrite(list);

    }

    public static void main(String[] args) {

        //onlyWriteExcel();

        readExcel();
    }


}
