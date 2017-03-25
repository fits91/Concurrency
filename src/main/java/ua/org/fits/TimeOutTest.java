package ua.org.fits;

import java.util.concurrent.*;

public class TimeOutTest {
    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
        Callable<String> task = TimeOutTest::sayHello;

        ExecutorService executor = Executors.newFixedThreadPool(2);
        Future<String> answer = executor.submit(task);

        System.out.println("isAnswerReceived? : " + answer.isDone());
        String result = answer.get(3, TimeUnit.SECONDS);
        System.out.println("isAnswerReceived? : " + answer.isDone());
        System.out.println(result);
    }

    static String sayHello() {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "hello";
    }
}
