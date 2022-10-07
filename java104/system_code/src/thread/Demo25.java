package thread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

// 咱们自己写的线程池类
// 简单实现成, 固定 10 个线程的线程池.
class MyThreadPool {
    // 这个队列就是 "任务队列" 把当前线程池要完成的任务都放到这个队列中.
    // 再由线程池内部的工作线程负责完成它们.
    private BlockingQueue<Runnable> queue = new LinkedBlockingQueue<>();

    // 核心方法, 往线程池里插入任务.
    public void submit(Runnable runnable) {
        try {
            queue.put(runnable);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // 设定线程池里有几个线程
    public MyThreadPool(int n) {
        // 构造方法中, 就需要创建一些线程, 让这些线程负责完成上述执行任务的工作!!
        for (int i = 0; i < n; i++) {
            Thread t = new Thread(() -> {
                while (!Thread.currentThread().isInterrupted()) {
                    try {
                        Runnable runnable = queue.take();
                        runnable.run();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        break;
                    }
                }
            });
            t.start();
        }
    }
}

public class Demo25 {
    public static void main(String[] args) {
        MyThreadPool myThreadPool = new MyThreadPool(10);
        for (int i = 0; i < 100; i++) {
            myThreadPool.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println("hello");
                }
            });
        }
    }
}
