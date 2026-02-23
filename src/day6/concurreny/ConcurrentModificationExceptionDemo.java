package day6.concurreny;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConcurrentModificationExceptionDemo {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));

        Thread t1 = new Thread(() -> {
            for(Integer value : list) {
                System.out.println("Reading: " + value);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
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
