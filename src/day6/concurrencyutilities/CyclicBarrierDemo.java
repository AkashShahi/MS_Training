package day6.concurrencyutilities;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ThreadPoolExecutor;

public class CyclicBarrierDemo {

    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {

        CyclicBarrier barrier = new CyclicBarrier(3, () -> {
            System.out.println("All players are ready. Game starts!");
        });

        Runnable task = () -> {
            try {
                System.out.println("Player readying: " + Thread.currentThread().getName());
                Thread.sleep(1000);
                System.out.println("Player ready: " + Thread.currentThread().getName());

                barrier.await();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (BrokenBarrierException e) {
                throw new RuntimeException(e);
            }
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);
        Thread t3 = new Thread(task);


        t1.start();
        t2.start();
        t3.start();

    }
}
