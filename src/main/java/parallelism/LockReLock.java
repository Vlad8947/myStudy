package parallelism;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class LockReLock {

    public static void doIt() {

        ReentrantLock reLock = new ReentrantLock();



    }

    private class LockThread implements Runnable {

        private String name = "Def";
        private ReentrantLock reLock;

        public LockThread(String name, ReentrantLock reLock) {
            this.name = name;
            this.reLock = reLock;
            new Thread(this).start();
        }

        @Override
        public void run() {

            System.out.println(name + " before Lock");

            if (reLock.tryLock()) reLock.unlock();

            reLock.lock();
            System.out.println(name + " in Lock");

            reLock.unlock();
            System.out.println(name + " after Lock");

        }

    }



}
