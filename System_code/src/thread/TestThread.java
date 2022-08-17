package thread;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JIE
 * Date: 2022-08-17
 * Time: 23:42
 */
public class TestThread {
    // 1. 单个线程，串行的，完成 20 亿次的自增
    // 2. 两个线程，并发的，完成 20 亿次的自增

    private static final long COUNT = 20_0000_0000;

    private static void serial(){
        // 记录时间
        long beg = System.currentTimeMillis();
        int a = 0;
        for (long i = 0; i < COUNT; i++) {
            a++;
        }
        a = 0;
        for (long i = 0; i < COUNT; i++) {
            a++;

        }

        long end = System.currentTimeMillis();
        System.out.println("单线程自增两遍消耗时间是：" + (end - beg) + " ms");
    }

    public static void concurrency(){
        long beg = System.currentTimeMillis();

        Thread thread1 = new Thread(() ->{
            int a = 0;
            for (long i = 0; i < COUNT; i++) {
                a++;
            }
        });
        Thread thread2 = new Thread(() ->{
            int a = 0;
            for (long i = 0; i < COUNT; i++) {
                a++;
            }
        });
        thread1.start();
        thread2.start();

        // join 就是等待线程执行结束
        // 在主线程中调用thread1.join  就是让main线程等待thread1执行完
        try {
            thread1.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        try {
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        long end = System.currentTimeMillis();
        System.out.println("并发执行各自自增一遍消耗总时间是：" + (end - beg) + " ms");
    }

    public static void main(String[] args) {
        TestThread.serial();
        TestThread.concurrency();
    }
}
