package com.libing.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class ValidateAspect {
	
	//切入点表达式
	@Pointcut("execution(* com.libing.aop.*.*(..))")
	private static void execute(){}
	
	@Before("execute()")
		public static void logStart(JoinPoint join){
			Object[] args = join.getArgs();
			String name = join.getSignature().getName();
			System.out.println("【前置validateAspect"+name+"】开始执行....."+Arrays.asList(args));
		}
	@AfterReturning(value="execute()",returning="result")
		public static void logReturn(JoinPoint join,Object result){//使用result来接受返回值
			String name = join.getSignature().getName();
			System.out.println("【返回结果validateAspect"+name+"】开始返回"+Arrays.asList(join.getArgs())+""+result+".....");
		}
	@AfterThrowing(value="execute()",throwing="ex")
		public static void logExe(JoinPoint join,Exception ex){
			String name = join.getSignature().getName();
			System.out.println("异常【validateAspect"+name+"】抛出异常"+Arrays.asList(join.getArgs())+""+ex+".......");
		}
	@After(value="execute()")
		public static void logAfter(JoinPoint join){
			String name = join.getSignature().getName();
			System.out.println("返回【validateAspect"+name+"】finally结束块"+Arrays.asList(join.getArgs())+"......");
		}
		
	
	
	
	
}
