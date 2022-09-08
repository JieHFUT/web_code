package ThreadSafety2;


import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JIE
 * Date: 2022-09-08
 * Time: 10:46
 */
public class Demo5 {

    public static void main(String[] args) {

        BlockingDeque<Integer> queue = new LinkedBlockingDeque<>();

        Thread customer = new Thread(() ->{
            while (true){
                try {
                    int value = queue.take();
                    System.out.println("消耗元素：" + value);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        });
        customer.start();

        Thread sever = new Thread(() ->{
            int n = 0;
            while (true){
                try {
                    System.out.println("生产元素：" + n);
                    queue.put(n);
                    Thread.sleep(500);
                    n++;
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        });
        sever.start();



    }
}

