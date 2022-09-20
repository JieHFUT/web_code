package ThreadSafety4;

import java.util.concurrent.PriorityBlockingQueue;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JIE
 * Date: 2022-09-14
 * Time: 18:11
 */
public class MyTimer {

    private Object locker = new Object();

    private PriorityBlockingQueue<MyTask> queue = new PriorityBlockingQueue<>();

    public void schedule(Runnable command, long after){
        MyTask myTask = new MyTask(command, after);

        synchronized (locker){
            queue.put(myTask);
            locker.notify();
        }
    }


    public MyTimer(){
        //在这里启动一个线程
        Thread thread = new Thread(()->{
            while (true){
                try {
                    synchronized (locker){
                        while (queue.isEmpty()){
                            locker.wait();
                        }
                        MyTask myTask = queue.take();
                        long curTime = System.currentTimeMillis();
                        if (myTask.getTime() > curTime){
                            queue.put(myTask);
                            locker.wait(myTask.getTime() - curTime);
                        }else {
                            myTask.run();
                        }
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        thread.start();

    }
}
