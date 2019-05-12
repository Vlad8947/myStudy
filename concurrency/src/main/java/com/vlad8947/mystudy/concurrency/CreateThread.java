package com.vlad8947.mystudy.concurrency;

public class CreateThread {

    private static class RunnableIml implements Runnable {

        @Override
        public void run() {
            //code
        }
    }

    private static class ThreadExt extends Thread {

        @Override
        public void run() {
            //super.run();
            //code
        }
    }

    private void startRunnable() {
        Runnable runnable = new RunnableIml();
        Thread thread = new Thread(runnable);
        thread.start();
    }

    private void startThread() {
        Thread thread = new ThreadExt();
        thread.start();
    }

}
