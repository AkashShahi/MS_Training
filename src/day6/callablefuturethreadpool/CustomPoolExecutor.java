package day6.callablefuturethreadpool;

import java.time.LocalDateTime;
import java.util.concurrent.*;

public class CustomPoolExecutor {

    public static void main(String[] args) {

        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(2, 4, 1, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(2), new CustomThreadFactor(), new CustomRejectedHandler());


        for(int i = 1; i <= 7; i++) {

            int taskNumber = i;

            poolExecutor.submit(() -> {

                System.out.println("Start: " + LocalDateTime.now() + " Task " + taskNumber + " is running on: " + Thread.currentThread().getName());
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("End: " + LocalDateTime.now() + " Task " + taskNumber + " Completed on: " + Thread.currentThread().getName());
            });
        }

        poolExecutor.shutdown();
    }
}

class CustomThreadFactor implements ThreadFactory {

    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r);
        return t;
    }
}

class CustomRejectedHandler implements RejectedExecutionHandler {

    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        System.out.println("Task Denied " + r.toString());
    }
}
