package com.kuang.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test09 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        //获得class对象
        Class c1 = Class.forName("com.kuang.reflection.User");
        // 构造一个对象
        User user = (User) c1.newInstance(); //类必须有一个无参数的构造器， 类的构造器的访问权限需要足够
        System.out.println(user);
        //通过构造器创建对象
        Constructor declaredConstructor = c1.getDeclaredConstructor(String.class, int.class, int.class);
        User user2 = (User) declaredConstructor.newInstance("xihengwang", 18, 12);
        System.out.println(user2);

        //通过反射调用普通方法
        User user3 = (User) c1.newInstance();
        //通过反射获取方法
        Method setName = c1.getDeclaredMethod("setName", String.class);
        setName.invoke(user3, "xihengwang"); //invoke:激活的意思(对象, "方法值")
        System.out.println(user3.getName());

        //通过反射操作属性
        User user4 = (User) c1.newInstance();
        Field name = c1.getDeclaredField("name");

        //不能只能操作私有属性，我们需要关闭程序的安全检测，属性或者方法的setAccessible(true);
        name.setAccessible(true);
        name.set(user4,"xihengwang2");
        System.out.println(user4.getName());

    }
}