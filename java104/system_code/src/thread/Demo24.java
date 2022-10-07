package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Demo24 {
    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(10);
        // Executors.newCachedThreadPool();

        for (int i = 0; i < 100; i++) {
            threadPool.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println("hello");
                }
            });
        }
    }
}
