package thread;

class MyThread extends Thread {
    @Override
    public void run() {
        while (true) {
            System.out.println("hello thread!");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class Demo1 {
    public static void main(String[] args) {
        // 创建一个线程
        // Java 中创建线程, 离不开一个关键的类, Thread
        // 一种比较朴素的创建线程的方式, 是写一个子类, 继承 Thread, 重写其中的 run 方法.
        Thread t = new MyThread();
        t.start();
        // t.run();
        // t.join();

        while (true) {
            System.out.println("hello main!");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
