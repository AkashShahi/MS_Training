package day6.concurreny;

import java.util.stream.IntStream;

public class IntStreamDemo {

    public static void main(String[] args) {

        IntStream.range(1, 101)
                .parallel()
                .forEach((i) -> System.out.println("Number " + i + " Process by thread: " + Thread.currentThread().getName()));
    }
}
