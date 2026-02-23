package day6.concurreny.atomicinteger;

import java.util.ArrayList;
import java.util.List;

public class main {

    public static void main(String[] args) throws InterruptedException {

        SharedCounter counter = new SharedCounter();

        AtomicIntegerDemo atomicIntegerDemo = new AtomicIntegerDemo(counter);
        List<Thread> threadList = new ArrayList<>();

        for(int i = 0; i < 1000; i++) {
            threadList.add(new Thread(atomicIntegerDemo));
            threadList.get(i).start();
        }

        for(int i = 0; i < 1000; i++) {
            threadList.get(i).join();
        }

        System.out.println(counter.counter.get());
    }
}
