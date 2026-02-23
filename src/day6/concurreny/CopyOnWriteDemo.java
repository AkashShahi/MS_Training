package day6.concurreny;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteDemo {

    public static void main(String[] args) {

         List<Integer> list = new CopyOnWriteArrayList<>(Arrays.asList(1, 2, 3, 4, 5));

        Thread t1 = new Thread(() -> {
            list.forEach((i) -> {
                System.out.println(i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
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

/*
Note : 1. for read heavy we should use CopyOnWriteArrayList.
       2. for write heavy we should use SynchronizedList.
 */
