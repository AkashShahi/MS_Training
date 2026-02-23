package day6.synchronizationandlock.racecondition;

public class RaceConditionDemo {

    private SharedCounter sharedCounter;

    public RaceConditionDemo(SharedCounter sharedCounter) {
        this.sharedCounter = sharedCounter;
    }

    public void incrementCounter() {
        sharedCounter.counter++;
    }
}
