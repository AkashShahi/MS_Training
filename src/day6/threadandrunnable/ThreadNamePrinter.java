package day6.threadandrunnable;

public class ThreadNamePrinter {

    public static void main(String[] args) {

        Thread task = new Thread(() -> {
            for(int i = 0; i <5; i++) {
                System.out.println("Current Thread: " + Thread.currentThread().getName());
            }
        });

        task.start();
    }
}
