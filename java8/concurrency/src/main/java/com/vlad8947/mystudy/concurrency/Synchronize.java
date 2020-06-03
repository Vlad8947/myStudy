package com.vlad8947.mystudy.concurrency;

public class Synchronize {

    private static Object lock1 = new Object();

    private static void someCode(String string) {
        for (int i = 0; i < 10; i++) {
            System.out.println(string + " " + i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /** Static sync method */
    private static synchronized void firstMethod(String string) {
        someCode(string);
    }

    /** Sync block */
    private static void secondMethod(String string) {
        synchronized (lock1) {
            someCode(string);
        }
    }

    /** Sync object */
    private synchronized void thirdMethod_1(String string) {
        someCode(string);
    }
    private synchronized void thirdMethod_2(String string) {
        someCode(string);
    }

    public static void main(String[] args) {

        Synchronize synchronize1 = new Synchronize();

        Thread t1 = new Thread(() -> {
            synchronize1.thirdMethod_1("t1");
        });
        Thread t2 = new Thread(() -> {
            synchronize1.thirdMethod_2("t2");
        });

        t1.start();
        t2.start();

    }

}
