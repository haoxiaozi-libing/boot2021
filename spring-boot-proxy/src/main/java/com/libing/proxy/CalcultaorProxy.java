package com.libing.proxy;


import com.libing.util.LogUtils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class CalcultaorProxy {

    public static Calcultaor getCalcutaor(Calcultaor calcultaor) {
        Object o = Proxy.newProxyInstance(calcultaor.getClass().getClassLoader(), calcultaor.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                int number = 0;
                try {
                    LogUtils.logStart(method, args);
                    number = (int) method.invoke(calcultaor, args);
                    LogUtils.logReturn(method, args,number);
                } catch (Exception e) {
                    LogUtils.logExe(method, args);
                } finally {
                    LogUtils.logAfter(method, args);
                }
                return number;
            }
        });
        return (Calcultaor) o;
    }

}
