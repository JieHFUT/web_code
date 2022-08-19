package ThreadFun;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JIE
 * Date: 2022-08-18
 * Time: 22:45
 */
// 创建两个线程

public class ThreadSafety1 {
    public static void main(String[] args) throws InterruptedException {
        TestSafety testSafety = new TestSafety();

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 5_0000; i++) {
                testSafety.addition();
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 5_0000; i++) {
                testSafety.addition();
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println(testSafety.number);

    }
}






