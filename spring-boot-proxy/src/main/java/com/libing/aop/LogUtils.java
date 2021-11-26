package com.libing.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author lvlibing
 * @create 2021-08-01 16:26
 */
@Component
@Aspect
public class LogUtils {

    @Pointcut("execution(* com.libing.aop.*.*(..))")
    public void expre() {

    }

    @Before("expre()")
    public static void logStart(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        System.out.println("【前置通知LogUtil" + name + "】开始执行" + Arrays.asList(joinPoint.getArgs()));
    }

    @AfterReturning(value = "expre()", returning = "result")
    public static void logReturn(JoinPoint joinPoint, Object result) {//使用result来接受返回值
        String name = joinPoint.getSignature().getName();
        System.out.println("返回通知【LogUtil" + name + "】开始执行" + Arrays.asList(joinPoint.getArgs())+"结果是"+result);
    }

    @AfterThrowing(value = "expre()", throwing = "ex")
    public static void logExe(JoinPoint joinPoint, Exception ex) {
        String name = joinPoint.getSignature().getName();
        System.out.println("异常通知【LogUtil" + name + "】开始执行" + Arrays.asList(joinPoint.getArgs())+"异常时"+ex);
    }

    @After("expre()")
    public static void logAfter(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        System.out.println("后置通知【LogUtil" + name + "】开始执行" + Arrays.asList(joinPoint.getArgs()));
    }


    // 环绕通知
    @Around("expre()")
    public static void around(ProceedingJoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        args[0]=100;
        try {
            System.out.println("【环绕 前置通知LogUtil" + name + "】开始执行" + Arrays.asList(joinPoint.getArgs()));

            // 真正的目标方法运行
            Object proceed = joinPoint.proceed(args);

            System.out.println("【环绕 返回通知LogUtil" + name + "】开始执行" + Arrays.asList(joinPoint.getArgs())+"结果是"+proceed);
        } catch (Throwable throwable) {
//            System.out.println("【环绕 异常通知LogUtil" + name + "】开始执行" + Arrays.asList(joinPoint.getArgs())+"异常时"+throwable);
        } finally {
            System.out.println("【环绕 后置通知LogUtil" + name + "】开始执行" + Arrays.asList(joinPoint.getArgs()));
        }

    }

}
