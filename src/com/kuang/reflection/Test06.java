package com.kuang.reflection;

//测试类什么时候会初始化
public class Test06 {
    static {
        System.out.println("Main类被加载");
    }

    public static void main(String[] args) throws ClassNotFoundException {
        //1.主动引用
//        Son son = new Son();
        //反射也会产生主动引用
//        Class.forName("com.kuang.reflection.Son");
        //2.不回产生类的应用的方法
//        System.out.println(Son.b);
//        Son[] array = new Son[5];
        System.out.println(Son.M);
    }

}

class Father{
    static int b = 2;
    static {
        System.out.println("父类被加载");
    }
}

class Son extends Father{
    static {
        System.out.println("子类被加载");
        m = 300;
    }

    static int m  = 100; //静态变量
    static final int M = 1;//静态常量
}
