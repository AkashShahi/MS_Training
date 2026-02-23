package day6.synchronizationandlock.ReaderWriter;

import java.util.List;
import java.util.concurrent.locks.Lock;

public class WriterThread {

    private SharedResource sharedResource;
    private Lock writeLock;

    public WriterThread(SharedResource sharedResource, Lock writeLock) {
        this.sharedResource = sharedResource;
        this.writeLock = writeLock;
    }

    public void writeData() {

        writeLock.lock();

        List<Integer> list = sharedResource.getList();
        int value = list.get(list.size() - 1);

//        System.out.println("Producing data: " + value);

        sharedResource.getList().add(value + 1);

        writeLock.unlock();
    }
}
