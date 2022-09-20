package ThreadSafety5;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JIE
 * Date: 2022-09-20
 * Time: 9:40
 */
public class Demo1 {

    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 100; i++) {
            threadPool.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println("this is a mission");
                }
            });
        }
        threadPool.shutdown();
    }
}
