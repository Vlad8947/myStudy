package com.vlad8947.mystudy.concurrency.lockers;

import java.util.concurrent.Semaphore;

public class SemaphoreDemo {

    public static class Program {

        public static void main(String[] args) {

            ReentrantLockDemo.coco();
            String str = ReentrantLockDemo.str;
            new ReentrantLockDemo();

            Semaphore sem = new Semaphore(1); // 1 разрешение
            CommonResource res = new CommonResource();
            new Thread(new CountThread(res, sem, "CountThread 1")).start();
            new Thread(new CountThread(res, sem, "CountThread 2")).start();
            new Thread(new CountThread(res, sem, "CountThread 3")).start();
        }
    }

    static class CommonResource{

        int x=0;
    }

    static class CountThread implements Runnable{

        CommonResource res;
        Semaphore sem;
        String name;

        CountThread(CommonResource res, Semaphore sem, String name){
            this.res=res;
            this.sem=sem;
            this.name=name;
        }

        @Override
        public void run(){

            try{
                System.out.println(name + " ожидает разрешение");
                sem.acquire();
                res.x=1;
                for (int i = 1; i < 5; i++){
                    System.out.println(this.name + ": " + res.x);
                    res.x++;
                    Thread.sleep(100);
                }
            }
            catch(InterruptedException e){System.out.println(e.getMessage());}
            System.out.println(name + " освобождает разрешение");
            sem.release();
        }
    }

}
