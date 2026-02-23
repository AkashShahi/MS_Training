package day6.concurreny;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SynchronizedListDemo {

    public static void main(String[] args) {

        List<Integer> list = Collections.synchronizedList(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5)));

        Thread t1 = new Thread(() -> {

            synchronized (list) {
                for(Integer value : list) {
                    System.out.println("Reading: " + value);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

        });

        Thread t2 = new Thread(() -> {
            try {
                Thread.sleep(150);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            list.add(10);
            System.out.println("Added new element");
        });

        t1.start();
        t2.start();
    }
}
