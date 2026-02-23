package day6.synchronizationandlock.lock;

import day6.synchronizationandlock.racecondition.SharedCounter;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockClient {

    public static void main(String[] args) throws InterruptedException {

        SharedCounter sharedCounter = new SharedCounter();
        ReentrantLock lock = new ReentrantLock();
        ReentrantLockDemo lockDemo = new ReentrantLockDemo(sharedCounter, lock);

        Runnable task = () -> {
            lockDemo.increment();
        };

        Runnable task1 = () -> {
            lockDemo.increment();
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task1);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(sharedCounter.counter);
    }
}
