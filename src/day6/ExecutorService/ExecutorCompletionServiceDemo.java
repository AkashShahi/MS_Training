package day6.ExecutorService;

import java.util.concurrent.*;

public class ExecutorCompletionServiceDemo {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        ExecutorService poolExecutor = Executors.newFixedThreadPool(3);

        CompletionService<String> completionService = new ExecutorCompletionService<>(poolExecutor);

        for(int i = 1; i <= 5; i++) {
            int taskId = i;

            completionService.submit(() -> {
                int sleeptime = (int)(Math.random() * 3000);
                Thread.sleep(sleeptime);

                return "File_" + taskId + ".txt processed by " + Thread.currentThread().getName();
            });
        }

        for(int i = 1; i <= 5; i++) {
            Future<String> future = completionService.take();
            String result = future.get();
            System.out.println("Completed " + result);
        }

        poolExecutor.shutdown();
    }
}
