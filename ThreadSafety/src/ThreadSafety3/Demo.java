package ThreadSafety3;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JIE
 * Date: 2022-09-20
 * Time: 9:41
 */
public class Demo {

    public static void main(String[] args) {

        BlockingDeque<Integer> deque = new LinkedBlockingDeque<>();

        Thread customer = new Thread(() ->{
            while (true){
                try {
                    int value = deque.take();
                    System.out.println("customer: " + value);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        customer.start();


        Thread producer = new Thread(()->{
            int n = 0;
            while (true){
                try {
                    deque.put(n);
                    System.out.println("producer: " + n);
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        producer.start();


    }
}
