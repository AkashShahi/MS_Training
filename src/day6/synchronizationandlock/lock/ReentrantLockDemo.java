package day6.synchronizationandlock.lock;

import day6.synchronizationandlock.racecondition.SharedCounter;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo {

    private SharedCounter sharedCounter;

    private ReentrantLock lock;

    public ReentrantLockDemo(SharedCounter sharedCounter, ReentrantLock lock) {
        this.sharedCounter = sharedCounter;
        this.lock = lock;
    }

    public void increment() {

        lock.lock();
        try {
            sharedCounter.counter++;
        } finally {
            lock.unlock();
        }




    }
}
