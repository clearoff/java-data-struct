package com.jvm.demo;

/**
 * 通过子类引用父类的静态字段,不会导致子类进行初始化
 */
public class SubClass extends SuperClass {
    static {
        System.out.println("SubClass Init ...");
    }

    public static void main(String[] args) {
        System.out.println(SubClass.value);
    }
}
