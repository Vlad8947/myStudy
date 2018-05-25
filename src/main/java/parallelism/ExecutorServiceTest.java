package parallelism;

import java.sql.Connection;
import java.sql.Statement;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceTest {

    public static void doit (int numThreads) {

        /** исполнитель потоков */

        ExecutorService executorService = Executors.newFixedThreadPool(numThreads);
        executorService.execute(new Thread());

    }

}
