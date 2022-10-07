package thread;

import java.util.PriorityQueue;
import java.util.concurrent.PriorityBlockingQueue;

// 通过这个类来描述一个任务.
class MyTask implements Comparable<MyTask> {
    // 任务要干啥
    private Runnable command;
    // 任务啥时候干
    private long time;

    public MyTask(Runnable command, long after) {
        this.command = command;
        // 此处记录的时间是一个绝对的时间戳. 不是 "多长时间之后能执行"
        this.time = System.currentTimeMillis() + after;
    }

    // 执行任务的方法, 直接在内部调用 Runnable 的 run 即可.
    public void run() {
        command.run();
    }

    public long getTime() {
        return time;
    }

    @Override
    public int compareTo(MyTask o) {
        // 希望时间小的在前面, 时间大的在后面
        // 这里谁减谁 才能达到时间小的在前~ 大家不要刻意背.
        // 写代码验证一下.
        return (int) (this.time - o.time);
    }
}

// 咱们自己创建的定时器类.
class MyTimer {
    // 这个是用来阻塞等待的锁对象
    private Object locker = new Object();

    // 使用优先级队列来保存若干个任务.
    private PriorityBlockingQueue<MyTask> queue = new PriorityBlockingQueue<>();

    // command 要执行的任务是啥
    // after 多长时间之后来执行这个任务
    public void schedule(Runnable command, long after) {
        MyTask myTask = new MyTask(command, after);
        synchronized (locker) {
            queue.put(myTask);
            locker.notify();
        }
    }

    public MyTimer() {
        // 在这里启动一个线程.
        Thread t = new Thread(() -> {
            while (true) {
                // 循环过程中, 就不断的尝试从队列中获取到队首元素.
                // 判定队首元素当前的时间是否就绪. 如果就绪了就执行, 不就绪, 就不执行.
                try {
                    synchronized (locker) {
                        // [在这里加个条件判定] 之前的代码有点问题.
                        while (queue.isEmpty()) {
                            locker.wait();
                        }
                        MyTask myTask = queue.take();
                        long curTime = System.currentTimeMillis();
                        if (myTask.getTime() > curTime) {
                            // 时间还没到, 塞回到队列中
                            queue.put(myTask);
                            locker.wait(myTask.getTime() - curTime);
                        } else {
                            // 时间到了~~, 直接执行任务
                            myTask.run();
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();
    }
}

public class Demo23 {
    public static void main(String[] args) {
        MyTimer myTimer = new MyTimer();
        myTimer.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("3333");
            }
        }, 6000);
        myTimer.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("2222");
            }
        }, 4000);
        myTimer.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("1111");
            }
        }, 2000);
    }
}
