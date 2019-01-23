package com.jvm.demo;


import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Method;

public class Foo {

    private static void bar(int num) {
        System.out.println("This if foo bar, [" + num + "]");
    }

    public static MethodHandles.Lookup lookup() {
        return MethodHandles.lookup();
    }

    /**
     * 获取方法句柄的不同方式
     * @param args
     */
    public static void main(String[] args) {
        MethodHandles.Lookup l = Foo.lookup();
        try {
            Method m = Foo.class.getDeclaredMethod("bar", int.class);
            MethodHandle mh0 = l.unreflect(m);
            mh0.invoke(1);
        } catch (Throwable e) {
            e.printStackTrace();
        }

        MethodType t = MethodType.methodType(void.class, int.class);
        try {
            MethodHandle mh1 = l.findStatic(Foo.class, "bar", t);
            mh1.invoke(2);
        } catch(Throwable ex) {
            ex.printStackTrace();
        }
    }
}
