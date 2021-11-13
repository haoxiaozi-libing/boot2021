package com.libing.线程间的通信;

/**
 * @author lvlibing
 * @create 2021-08-31 6:46
 */
public class TestObject {
    private int num=0;
    private static Object object=new Object();
    public void odd(){

        while (num<10) {
            synchronized (object) {
                if(num%2==1){
                    System.out.println(Thread.currentThread().getName()+"--->"+ num++);
                    object.notify();
                }else {
                    try {
                        object.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
    public void incr(){
        while (num<10) {
            synchronized (object) {
                if(num%2==0){
                    System.out.println(Thread.currentThread().getName()+"--->"+ num++);
                    object.notify();
                }else {
                    try {
                        object.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }


    public static void main(String[] args) {
        TestObject testObject=new TestObject();
        Thread thread1=new Thread(()->testObject.odd());
        Thread thread2=new Thread(()->testObject.incr());
        thread1.start();
        thread2.start();
    }













}
