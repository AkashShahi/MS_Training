package day6.callablefuturethreadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolCacheDemo {

    public static void main(String[] args) {

        ExecutorService poolExecutor = Executors.newCachedThreadPool();

        for(int i = 1; i <= 10; i++) {

            int taskNumber = i;

            poolExecutor.submit(() -> {
                System.out.println("Task " + taskNumber + " is running on " + Thread.currentThread().getName());
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }

        poolExecutor.shutdown();
    }
}
