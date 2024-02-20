package ch14.sec09.exam03;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableSubmitExampleV2 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        for (int i = 1; i <= 100; i++) {
            final int idx = i;

            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    int sum = 0;
                    for (int i = 1; i <= idx; i++) {
                        sum += i;
                    }
                    Thread thread = Thread.currentThread();
                    System.out.println("[" + thread.getName() + "]");
                }
            });
        }
        executorService.shutdown();
    }
}
