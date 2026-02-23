package day6.callablefuturethreadpool;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class main {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        SumCalculationTask task = new SumCalculationTask(100);

        ExecutorService poolExecutor = Executors.newSingleThreadExecutor();

        Future<Integer> sum = poolExecutor.submit(task);

        System.out.println(sum.get());

        poolExecutor.shutdown();
    }
}
