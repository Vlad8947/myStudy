package parallelism;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureCallable {

    static class Sum implements Callable<Integer> {

        int stop;

        public Sum(int stop) {
            this.stop = stop;
        }

        @Override
        public Integer call() throws Exception {

            int sum = 0;
            for (int i = 1; i <= stop; i++) {
                sum += i;
            }
            return sum;
        }
    }


    public static void doit () {

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        Future<Integer> future;

        future = executorService.submit(new Sum(10));

    }

}
