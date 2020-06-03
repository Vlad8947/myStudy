package com.vlad8947.mystudy.concurrency;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;

/**
 * Асинхронное выполнение задач в многопоточной системе на нескольких процессорах
 * */

public class ForkJoin {

    // Класс выполнения задачи
    private static class MyRecursiveAction extends RecursiveAction {

        public MyRecursiveAction() {
        }

        @Override
        protected void compute() {
            /**Execution code*/
        }
    }

    public static void doIt () {

        ForkJoinPool forkJoinPool = new ForkJoinPool(/*parallelism level*/); // Пул управления задачами потоков
        MyRecursiveAction myRecursiveAction = new MyRecursiveAction();
        forkJoinPool.invoke(myRecursiveAction); // execute compute and wait to the end

        // Or
        myRecursiveAction.fork();   // execute compute in a system pool
        myRecursiveAction.join();   // wait to the end
        myRecursiveAction.invoke(); // execute compute in a system pool, and wait to the end
        ForkJoinPool.commonPool().execute(myRecursiveAction);  // call a system pool

        // Interrupt action
        /** Interrupt if work.
         *   return true if interrupt
         *   else if don't work or can't interrupt*/
        myRecursiveAction.cancel(true);
        myRecursiveAction.isCancelled();

        myRecursiveAction.isCompletedNormally();
        myRecursiveAction.isCompletedAbnormally();

        // Reinitialize the state of action for restart.
        myRecursiveAction.reinitialize();

        // ForkJoinTask forkJoinTask = ForkJoinTask.adapt();

        /** Don't return and don't throw exception */
        myRecursiveAction.quietlyInvoke();
        myRecursiveAction.quietlyJoin();

        myRecursiveAction.tryUnfork();
        forkJoinPool.toString();

    }

}
