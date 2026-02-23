package day6.threadandrunnable;

public class main {

    public static void main(String[] args) {

        PrintNumberWithDelay task = new PrintNumberWithDelay();

        Thread t = new Thread(task);

        t.start();
    }
}
