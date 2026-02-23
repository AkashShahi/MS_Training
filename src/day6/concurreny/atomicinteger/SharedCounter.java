package day6.concurreny.atomicinteger;

import java.util.concurrent.atomic.AtomicInteger;

public class SharedCounter {

    AtomicInteger counter = new AtomicInteger(4);
}
