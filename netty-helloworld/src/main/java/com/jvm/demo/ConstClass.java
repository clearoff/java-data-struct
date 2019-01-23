package com.jvm.demo;

public class ConstClass {
    static {
        System.out.println("ConstClass Init ...");
    }

    // 常量在编译阶段会存入调用类的常量池中, 没有引用定义常量池的类
    public static final String HELLOWORLD = "Hello, World!";
}
