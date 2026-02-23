package day6.synchronizationandlock.synchronization;

import day6.synchronizationandlock.racecondition.SharedCounter;

public class ThreadSafeDemo implements Runnable{

    private SharedCounter sharedCounter;

    public ThreadSafeDemo(SharedCounter sharedCounter) {
        this.sharedCounter = sharedCounter;
    }

    @Override
    public void run() {
        synchronized (sharedCounter) {
            sharedCounter.counter++;
        }
    }
}
