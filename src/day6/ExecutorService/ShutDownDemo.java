package day6.ExecutorService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ShutDownDemo {

    public static void main(String[] args) {

        ExecutorService poolExecutor = Executors.newFixedThreadPool(5);

        poolExecutor.submit(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println("new task");
        });

        poolExecutor.shutdown();

        System.out.println("Main thread unblocked and finished processing");
    }
}
