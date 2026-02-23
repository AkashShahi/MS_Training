package day6.synchronizationandlock.synchronization;

import day6.synchronizationandlock.racecondition.SharedCounter;

public class ThreadSafeClient {

    public static void main(String[] args) throws InterruptedException {

        SharedCounter sharedCounter = new SharedCounter();

        ThreadSafeDemo safeDemo = new ThreadSafeDemo(sharedCounter);

        Thread t1 = new Thread(safeDemo);
        Thread t2 = new Thread(safeDemo);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(sharedCounter.counter);
    }
}
