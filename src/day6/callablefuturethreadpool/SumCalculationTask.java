package day6.callablefuturethreadpool;

import java.util.concurrent.*;

public class SumCalculationTask implements Callable<Integer> {

    private int length;

    public SumCalculationTask(int length) {
        this.length = length;
    }

    @Override
    public Integer call() throws Exception {

        int sum = 0;

        for(int i = 1; i <= length; i++) {
            sum += i;
        }

        return sum;
    }
}
