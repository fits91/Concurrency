package ua.org.fits;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorTest {
    public static void main(String[] args) {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        Runnable task = () -> {
            String threadName = Thread.currentThread().getName();
            System.out.println("\n" + threadName);
            System.out.println("time: " + System.nanoTime());
        };
        ScheduledFuture<?> future = executor.schedule(task, 2, TimeUnit.SECONDS);
        long remainingDelay = future.getDelay(TimeUnit.MILLISECONDS);
        System.out.printf("Remaining Delay: %sms", remainingDelay);
    }

}
