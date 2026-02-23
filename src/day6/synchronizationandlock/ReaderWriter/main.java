package day6.synchronizationandlock.ReaderWriter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class main {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));

        SharedResource sharedResource = new SharedResource(list);
        ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
        Lock readLock = readWriteLock.readLock();
        Lock writeLock = readWriteLock.writeLock();

        ReaderThread reader = new ReaderThread(sharedResource, readLock);
        WriterThread writer = new WriterThread(sharedResource, writeLock);

        Runnable readerTask = () -> {
            for(int i = 0; i <3; i++) {
                try {
                    reader.readData();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        Runnable writerTask = () -> {
            for(int i = 0; i < 2; i++) {
                writer.writeData();
            }
        };

        Thread r1 = new Thread(readerTask);
        Thread r2 = new Thread(readerTask);
        Thread w1 = new Thread(writerTask);

        r1.start();
        r2.start();
        w1.start();
    }
}
