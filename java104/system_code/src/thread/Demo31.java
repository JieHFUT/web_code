package thread;

import java.util.concurrent.Semaphore;

public class Demo31 {
    public static void main(String[] args) throws InterruptedException {
        // 构造方法传入有效资源的个数
        Semaphore semaphore = new Semaphore(3);

        // P 操作 申请资源
        semaphore.acquire();
        System.out.println("申请资源");
        semaphore.acquire();
        System.out.println("申请资源");
        semaphore.acquire();
        System.out.println("申请资源");
        semaphore.acquire();
        System.out.println("申请资源");
        // V 操作 释放资源
        // semaphore.release();
    }
}
