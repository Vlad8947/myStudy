package com.vlad8947.mystudy.concurrency.locks;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo {

    public static String str;

    static {

    }

    public ReentrantLockDemo() {

    }

    public static void coco(){}


    public static class Program {

        public static void main(String[] args) {

            CommonResource commonResource= new CommonResource();
            ReentrantLock locker = new ReentrantLock(); // создаем заглушку
            for (int i = 1; i < 6; i++){

                Thread t = new Thread(new CountThread(commonResource, locker));
                t.setName("Thread "+ i);
                t.start();
            }
        }
    }

    static class CommonResource{

        int x=0;
    }

    static class CountThread implements Runnable{

        CommonResource res;
        ReentrantLock locker;

        CountThread(CommonResource res, ReentrantLock lock){
            this.res=res;
            locker = lock;
        }

        @Override
        public void run(){

            locker.lock(); // устанавливаем блокировку
            try{
                res.x=1;
                for (int i = 1; i < 5; i++){
                    System.out.printf("%s %d \n", Thread.currentThread().getName(), res.x);
                    res.x++;
                    Thread.sleep(100);
                }
            }
            catch(InterruptedException e){
                System.out.println(e.getMessage());
            }
            finally{
                locker.unlock(); // снимаем блокировку
            }
        }
    }

}
