package com.libing;

import com.libing.proxy.Calcultaor;
import com.libing.proxy.CalcultaorProxy;
import com.libing.proxy.MyMathCatalator;
import org.junit.Test;

/**
 * @author lvlibing
 * @create 2021-08-01 16:32
 */
public class TestDemo {
    @Test
    public void Test1(){
        Calcultaor calcultaor=new MyMathCatalator();
        Calcultaor calcutaor = CalcultaorProxy.getCalcutaor(calcultaor);
        calcultaor.div(1,2);
    }
}
