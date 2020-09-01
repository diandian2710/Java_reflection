package com.kuang.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

//获得类的信息
public class Test08 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException {
        Class c1 = Class.forName("com.kuang.reflection.User");
        System.out.println("==================================");

        //获得类的名字
        System.out.println(c1.getName()); //包名+类名
        System.out.println(c1.getSimpleName());//获得类名

        System.out.println("==================================");
        //获得类的属性
        Field[] fields = c1.getFields(); //只能找到public属性
        for(Field field:fields){
            System.out.println(field);
        }

        Field[] declaredFields = c1.getDeclaredFields(); //找到全部的属性
        for(Field field:declaredFields){
            System.out.println(field);
        }
        System.out.println("==================================");

        //获得指定属性的值
        Field name = c1.getDeclaredField("name");
        System.out.println(name);

        System.out.println("==================================");
        //获得类的方法
        Method[] methods = c1.getMethods(); //获得本类及其父类的全部public方法(不包括private方法）
        for(Method method:methods){
            System.out.println("正常的:"+method);
        }

        Method[] declaredMethods = c1.getDeclaredMethods(); //获得本类的所有方法(包括private方法)
        for(Method declaredMethod:declaredMethods){
            System.out.println("getDeclaredMethod" + declaredMethod);
        }

        //获得指定方法
        //重载
        System.out.println("==================================");
        Method getName = c1.getMethod("getName");
        System.out.println(getName);
        Method setName = c1.getMethod("setName", String.class);
        System.out.println(setName);

        //获得构造器
        System.out.println("==================================");
        Constructor[] constructors = c1.getConstructors(); //只能获得public构造器
        for (Constructor constructor : constructors) {
            System.out.println(constructor);
        }

        Constructor[] declaredConstructors = c1.getDeclaredConstructors(); //获得全部的构造器（包括private）
        for (Constructor declaredConstructor : declaredConstructors) {
            System.out.println(declaredConstructor);
        }

        //获得指定构造器
        System.out.println("==================================");
        Constructor constructor = c1.getConstructor(String.class, int.class, int.class);
        System.out.println(constructor);

        Constructor constructor1 = c1.getConstructor();
        System.out.println(constructor1);

        Constructor declaredConstructor = c1.getDeclaredConstructor(String.class, int.class, int.class);
        System.out.println(declaredConstructor);


    }
}
