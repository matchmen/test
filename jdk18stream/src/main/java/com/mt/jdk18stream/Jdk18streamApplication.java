package com.mt.jdk18stream;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Jdk18streamApplication {

    public static void main(String[] args) {

        List<User> users = new ArrayList<>();

        User user1 = new User(1,"科比",37,"湖人");
        User user2 = new User(2,"詹姆斯",35,"骑士");
        User user3 = new User(3,"韦德",39,"热火");
        User user4 = new User(4,"邓肯",37,"马刺");
        User user5 = new User(5,"乔丹",47,"公牛");
        User user6 = new User(6,"杜兰特",31,"雷霆");
        User user7 = new User(7,"库里",31,"勇士");
        User user8 = new User(8,"哈登",30,"火箭");
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        users.add(user5);
        users.add(user6);
        users.add(user7);
        users.add(user8);
        users.add(user8);

        System.out.println("--------------所有---------------");
        users.stream().distinct().forEach(System.out::println);

        //筛选大于37岁的人的名字  filter 返回true时被选中
        System.out.println("--------------过滤，筛选大于37岁的人的名字  filter 返回true时被选中--------------");
        users.stream().filter(user -> user.getAge() > 37).forEach(System.out::println);

        //取出地址
        System.out.println("--------------集合转换，取出地址---------------");
        users.stream().map(user -> user.getAddress()).forEach(System.out::println);

        //去重
        System.out.println("--------------去重---------------");
        users.stream().distinct().forEach(System.out::println);


        //排序
        System.out.println("--------------排序:年龄从小到大---------------");
        users.stream().sorted((u1,u2)->Integer.compare(u1.getAge(),u2.getAge())).forEach(System.out::println);

        //返回限制个数
        System.out.println("--------------返回限制个数 4 个---------------");
        users.stream().limit(4).forEach(System.out::println);

        //删除指定个数
        System.out.println("--------------删除指定个数 4 个---------------");
        users.stream().skip(4).forEach(System.out::println);

        //最小年龄
        System.out.println("--------------最小年龄---------------");
        System.out.println(users.stream().min((u1, u2) -> Integer.compare(u1.getAge(), u2.getAge())).get().getUsername());

        //匹配
        System.out.println("--------------匹配 是否有叫韦德的人---------------");
        boolean b = users.stream().anyMatch(user ->user.getUsername().equals("韦德"));
        System.out.println(b ? "有叫韦德的":"没有叫韦德的");

        //分组
        System.out.println("--------------根据年龄分组---------------");
        users.stream().collect(Collectors.groupingBy(user -> user.getAge())).entrySet().forEach(System.out::println);

        //
        System.out.println("--------------输出所有人姓名,以逗号分隔---------------");
        System.out.println(users.stream().map(user -> user.getUsername()).collect(Collectors.joining(",")));

        System.out.println("--------------平均年龄---------------");
        System.out.println(users.stream().collect(Collectors.averagingInt(value -> value.getAge())));

        System.out.println("--------------年龄总和---------------");
        System.out.println(users.stream().collect(Collectors.summingInt(value -> value.getAge())));

        System.out.println("--------------并发输出---------------");
        users.parallelStream().forEach(user -> {
            System.out.println(Thread.currentThread().getName()+"---->"+user);
        });



    }
}
