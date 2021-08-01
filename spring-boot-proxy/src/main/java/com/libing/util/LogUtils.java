package com.libing.util;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author lvlibing
 * @create 2021-08-01 16:26
 */
public class LogUtils {

    public static void logStart(Method method,Object[] args){
        System.out.println("【LogUtil"+method.getName()+"】开始执行"+ Arrays.asList(args));
    }

    public static void logReturn(Method method,Object[] args,int num){//使用result来接受返回值
        System.out.println("【LogUtil"+method.getName()+"】开始返回"+num);
    }
    public static void logExe(Method method,Object[] args){
        System.out.println("【LogUtil"+method.getName()+"】抛出异常"+Arrays.asList(args));
    }
    public static void logAfter(Method method,Object[] args){
        System.out.println("【LogUtil"+method.getName()+"】finally结束块"+Arrays.asList(args));
    }

}
