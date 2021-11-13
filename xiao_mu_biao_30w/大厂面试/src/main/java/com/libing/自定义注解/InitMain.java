package com.libing.自定义注解;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author lvlibing
 * @create 2021-09-11 13:26
 */
public class InitMain {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        Class<?> aClass = Class.forName("com.libing.自定义注解.InitDemo");
        Method[] methods = aClass.getMethods();
        if(methods!=null){
            for (Method method : methods) {
                boolean annotationPresent = method.isAnnotationPresent(InitMethod.class);
                if(annotationPresent){
                    System.out.println(method.getName()+""+annotationPresent);
                    Object invoke = method.invoke(aClass.getConstructor(null).newInstance(null),null);

                }
            }

        }
    }
}
