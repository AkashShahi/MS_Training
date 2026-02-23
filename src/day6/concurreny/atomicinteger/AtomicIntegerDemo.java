package day6.concurreny.atomicinteger;

public class AtomicIntegerDemo implements Runnable{

    private SharedCounter counter;

    public AtomicIntegerDemo(SharedCounter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        counter.counter.incrementAndGet();
    }
}
