package com.jvm.demo;

import java.util.Collections;
import java.util.List;

public class Test {
    private static final int _1MB = 1024 * 1024;

    public static void invoke(Object obj1, Object ... args) {
        System.out.println("This is Object invoke ...");
    }

    public static void invoke(String obj1, Object obj2, Object ... args) {
        System.out.println("This is String invoke ...");
    }

    public static void testAllocation() {
        byte[] allocation1, allocation2, allocation3, allocation4;
        allocation1 = new byte[2 * _1MB];
        allocation2 = new byte[2 * _1MB];
        allocation3 = new byte[2 * _1MB];
        allocation4 = new byte[4 * _1MB];
    }

    public static void testSingleTonList() {
        List<String> list = Collections.singletonList("Hello, World");
        System.out.println(list);
    }

    public static void main(String[] args) {
//        testAllocation();
//        System.out.println("Hello, GC !");
//        testSingleTonList();
        // Test1 : 通过子类使用父类的静态字段
        //System.out.println(SubClass.value);

        // Test2 : 通过数组定义来引用类, 不会触发此类的初始化
        // SuperClass[] sca = new SuperClass[10];

        // Test3 : 常量在编译阶段会存入调用类的常量池中, 本质上并没有直接引用到定义常量的类, 因此不会触发定义常量的类的初始化

    }
}
