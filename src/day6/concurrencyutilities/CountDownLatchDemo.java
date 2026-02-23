package day6.concurrencyutilities;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {

    public static void main(String[] args) throws InterruptedException {

        CountDownLatch latch = new CountDownLatch(3);

        Runnable task = () -> {
            try {
                System.out.println("Initializing the thread: " + Thread.currentThread().getName());
                Thread.sleep(2000);
                System.out.println("Thread Initialization completed: " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                latch.countDown();
            }
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);
        Thread t3 = new Thread(task);

        t1.start();
        t2.start();
        t3.start();

        latch.await();

        System.out.println("Main Thread finished: " + Thread.currentThread().getName());
    }
}
