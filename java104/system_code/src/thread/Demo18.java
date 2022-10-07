package thread;

import java.util.Scanner;

// 创建两个线程, 一个线程调用 wait, 一个线程调用 notify
public class Demo18 {
    // 这个对象用来作为锁对象
    public static Object locker = new Object();
    public static Object locker2 = new Object();

    public static void main(String[] args) {
        // 用来取等待
        Thread waitTask = new Thread(() -> {
            synchronized (locker) {
                try {
                    System.out.println("wait 开始");
                    locker.wait();
                    System.out.println("wait 结束");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        waitTask.start();

        // 创建一个用来通知/唤醒的线程
        Thread notifyTask = new Thread(() -> {
            // 让用户来控制~ 用户输入个内容之后, 再执行通知!
            Scanner scanner = new Scanner(System.in);
            System.out.println("输入任意内容, 开始通知:");
            // next 会阻塞, 直到用户真正输入内容以后
            scanner.next();

            synchronized (locker2) {
                System.out.println("notify 开始");
                locker2.notify();
                System.out.println("notify 结束");
            }
        });
        notifyTask.start();
    }
}
