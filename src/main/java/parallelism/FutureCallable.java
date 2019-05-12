package parallelism;

import java.util.concurrent.*;

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
        try {
            System.out.println(future.get(10, TimeUnit.SECONDS));

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        executorService.shutdown();
    }

}
