package com.libing.类加载器;

/**
 * @author lvlibing
 * @create 2021-09-12 20:25
 */
public class MyAppClassLoad {

    public static void main(String[] args) {
        ClassLoader classLoader = MyAppClassLoad.class.getClassLoader();
        ClassLoader parent = classLoader.getParent();
        ClassLoader parent1 = parent.getParent();
        System.out.println(parent1);
        new Thread().start();
    }
}
