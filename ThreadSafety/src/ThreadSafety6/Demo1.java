package ThreadSafety6;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JIE
 * Date: 2022-09-21
 * Time: 17:46
 */
public class Demo1 {

    public static AtomicInteger count = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {

        Thread thread1 = new Thread(()->{
            for (int i = 0; i < 50_000; i++) {
                count.getAndIncrement();
            }
        });


        Thread thread2 = new Thread(()->{
            for (int i = 0; i < 50_000; i++) {
                count.getAndIncrement();
            }
        });


        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("count = " + count);
    }


}

