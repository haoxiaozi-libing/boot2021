package com.libing.面试题.线程打印ABC各5次;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author lvlibing
 * @create 2021-09-11 19:18
 */
public class PrintMain {
    Lock lock = new ReentrantLock();
    Condition conditionA = lock.newCondition();
    Condition conditionB = lock.newCondition();
    Condition conditionC = lock.newCondition();
    static int num = 0;

    private void printA() throws InterruptedException {
        if (num == 0) {
            lock.lock();
            try {
                System.out.println("print A.............");
                num++;
                conditionB.signal();
                conditionA.await();
            } catch (InterruptedException e) {

            } finally {
                lock.unlock();
            }
        }
    }

    private void printB() throws InterruptedException {
        if (num == 1) {
            lock.lock();
            try {
                System.out.println("print B.............");
                num++;
                conditionC.signal();
                conditionB.await();
            } catch (InterruptedException e) {

            } finally {
                lock.unlock();
            }
        }
    }

    private void printC() throws InterruptedException {
        if (num == 2) {
            lock.lock();
            try {
                System.out.println("print C.............");
                num = 0;
                conditionA.signal();
                conditionC.await();
            } catch (InterruptedException e) {

            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().availableProcessors());

        long max = Runtime.getRuntime().maxMemory();
        long total = Runtime.getRuntime().totalMemory();
        System.out.println(max/(double)1024/1024);
        System.out.println(total/(double)1024/1024);



        PrintMain printMain = new PrintMain();
        new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    printMain.printA();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    printMain.printB();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        new Thread(() -> {
            try {
                for (int i = 0; i <10; i++) {
                    printMain.printC();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }

}
