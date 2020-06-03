package com.vlad8947.mystudy.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceExample {

    private static class Runn implements Runnable {
        @Override
        public void run() {
            System.out.println("Асинхронная задача");
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        executorService.execute(new Runn());
        executorService.execute(new Runn());
        executorService.execute(new Runn());

        executorService.shutdown();
    }

}
