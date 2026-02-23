package day6.threadandrunnable;

public class FileTaskAggregator {

    public static void main(String[] args) throws InterruptedException {

        Thread task1 = new Thread(() -> {
            System.out.println("Task 1 completed");
        });

        Thread task2 = new Thread(() -> {
            System.out.println("Task 2 completed");
        });

        Thread task3 = new Thread(() -> {
            System.out.println("Task 3 completed");
        });

        task1.start();
        task2.start();
        task3.start();

        task1.join();
        task2.join();
        task3.join();

        System.out.println("All files downloaded");
    }
}
