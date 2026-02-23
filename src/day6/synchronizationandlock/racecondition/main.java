package day6.synchronizationandlock.racecondition;

public class main {

    public static void main(String[] args) throws InterruptedException {

        SharedCounter sharedCounter = new SharedCounter();
        RaceConditionDemo demo = new RaceConditionDemo(sharedCounter);

        Runnable task = () -> {
            demo.incrementCounter();
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(sharedCounter.counter);
    }
}
