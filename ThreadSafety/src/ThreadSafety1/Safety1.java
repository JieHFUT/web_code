package ThreadSafety1;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JIE
 * Date: 2022-08-19
 * Time: 22:12
 */
public class Safety1 {
    public static void main(String[] args) throws InterruptedException {
        TestSafety1 testSafety = new TestSafety1();

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 5_0000; i++) {
                //testSafety.addition();
                testSafety.additionNor();
                //TestSafety1.func3();
                //TestSafety1.func4();
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 5_0000; i++) {
                //testSafety.addition();
                testSafety.additionNor();
                //TestSafety1.func3();
                //TestSafety1.func5();
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("number: " + testSafety.number);
        //System.out.println(TestSafety1.num);


    }
}







