package day6.ExecutorService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;

public class ExecutorShutDownExample {

    public static void main(String[] args) {

        ExecutorService poolexecutor = Executors.newFixedThreadPool(4);

        poolexecutor.submit(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println("new task");
        });

        poolexecutor.shutdown();


        try {
            poolexecutor.submit(() -> {
                System.out.println("Submitting a new task after calling shutdown method ");
            });
        } catch(RejectedExecutionException e) {
            System.out.println("after shutdown no new task will be taken by the executor");
        }

        System.out.println("main thread finished processing ");

    }
}
