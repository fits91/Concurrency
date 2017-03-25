package ua.org.fits;

import java.util.concurrent.TimeUnit;

public class RunnableTest2 {
    public static void main(String[] args) {
        Runnable task = () -> {
            try {
                String name = Thread.currentThread().getName();
                System.out.println("beforeSleep " + name);
                TimeUnit.SECONDS.sleep(1);
                System.out.println("afterSleep " + name);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Thread thread = new Thread(task);
        thread.start();
    }
}
