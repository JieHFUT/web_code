package ThreadSafety5;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JIE
 * Date: 2022-09-20
 * Time: 16:48
 */
public class MyThreadPool {


    private BlockingQueue<Runnable> queue = new LinkedBlockingDeque<>();

    public void submit(Runnable runnable){
        try {
            queue.put(runnable);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public MyThreadPool(int n){
        for (int i = 0; i < n; i++) {
            Thread thread = new Thread(()->{
               while (!Thread.currentThread().isInterrupted()){
                   try {
                       Runnable runnable = queue.take();
                       runnable.run();
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
               }
            });
            thread.start();
        }
    }








}
