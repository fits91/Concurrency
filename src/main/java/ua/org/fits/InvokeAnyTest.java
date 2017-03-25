package ua.org.fits;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class InvokeAnyTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newWorkStealingPool();
        List<Callable<Integer>> callables = Arrays.asList(
            getCallable(1, 3),
            getCallable(2, 2),
            getCallable(3, 1)
        );

        Integer result = executor.invokeAny(callables);
        System.out.println(result);
    }

    static Callable<Integer> getCallable(Integer result, long sleepVal) {
        return () -> {
            TimeUnit.SECONDS.sleep(sleepVal);
            return result;
        };
    }
}
