package ThreadSafety1;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JIE
 * Date: 2022-09-06
 * Time: 23:55
 */
public class Safety4 {

    public static void main(String[] args) throws InterruptedException {

        TestSafety4 testSafety41 = new TestSafety4();
        TestSafety4 testSafety42 = new TestSafety4();


        Thread thread1 = new Thread(() -> {
            synchronized (testSafety41) {
                for (int i = 0; i < 5_0000; i++) {
                    testSafety41.add();
                }
            }
        });
        thread1.start();

        Thread thread2 = new Thread(() -> {
            synchronized (testSafety41) {
                for (int i = 0; i < 5_0000; i++) {
                    testSafety41.add();
                }
            }
        });
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println(testSafety41.number);
        System.out.println(testSafety42.number);

        //由此可见，类锁同时对实例属性有竞争约束
    }
}
