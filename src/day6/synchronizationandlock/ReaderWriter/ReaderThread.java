package day6.synchronizationandlock.ReaderWriter;

import java.util.concurrent.locks.Lock;

public class ReaderThread {

    private SharedResource sharedResource;
    private Lock readLock;

    public ReaderThread(SharedResource sharedResource, Lock readLock) {
        this.sharedResource = sharedResource;
        this.readLock = readLock;
    }

    public void readData() throws InterruptedException {

        Thread.sleep(1000);

        readLock.lock();

        System.out.println("list is " + sharedResource.getList());

        readLock.unlock();

    }

}
