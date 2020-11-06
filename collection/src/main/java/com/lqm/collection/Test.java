package com.lqm.collection;

import java.util.*;
import java.util.stream.Collectors;

public class Test {

    public static void main(String[] args) {

        List<Student> list = getList(10_000_000);

        long start = System.currentTimeMillis();

        //traditionFunction(list);
        Student student = null;
        for (int i = 0; i < list.size(); i++) {
            if(Objects.isNull(student)){
                student = list.get(i);
                continue;
            }
            if(student.getHeight() < list.get(i).getHeight()){
                student = list.get(i);
            }
        }
        System.out.println("身高最高为：" + student.getHeight());
        System.out.println("传统耗时:" + (System.currentTimeMillis() - start));
        start = System.currentTimeMillis();
        //streamFunction(list);
        int asInt = list.stream().parallel().mapToInt(Student::getHeight).max().getAsInt();
        System.out.println("身高最高为：" + asInt);
        System.out.println("Stream耗时:" + (System.currentTimeMillis() - start));

    }

    public static void traditionFunction(List<Student> stuList) {
        Map<String, List<Student>> stuMap = new HashMap<String, List<Student>>();
        for (Student stu: stuList) {
            if (stu.getHeight() > 160) { //如果身高大于160
                if (stuMap.get(stu.getSex()) == null) { //该性别还没分类
                    List<Student> list = new ArrayList<Student>(); //新建该性别学生的列表
                    list.add(stu);//将学生放进去列表
                    stuMap.put(stu.getSex(), list);//将列表放到map中
                } else { //该性别分类已存在
                    stuMap.get(stu.getSex()).add(stu);//该性别分类已存在，则直接放进去即可
                }
            }
        }
        System.out.printf("size:", stuMap.size());
    }

    public static void streamFunction(List<Student> stuList) {

        Map<String, List<Student>> stuMap = stuList.stream().filter((Student s) -> s.getHeight() > 160) .collect(Collectors.groupingBy(Student ::getSex));

        System.out.printf("size:", stuList.size());
    }

    public static List<Student> getList(int count) {

        List<Student> list = new ArrayList<>(count);

        for (int i = 0; i < count; i++) {
            Random r = new Random();
            int nextInt = r.nextInt(30);
            String sex = nextInt % 2 == 0 ? "男" : "女";
            list.add(new Student(nextInt+130,sex));
        }

        return list;
    }




}
