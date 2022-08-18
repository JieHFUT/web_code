package thread;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JIE
 * Date: 2022-08-18
 * Time: 16:16
 */

public class LearnThread7 {
    private static Thread thread1 = null;
    private static Thread thread2 = null;

    public static void main(String[] args) throws InterruptedException {
        System.out.println("main begin");


        thread1 = new Thread(() -> {
           System.out.println("thread1 begin");
           try {
               Thread.sleep(2000);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
           System.out.println("thread1 end");
       });
       thread1.start();

       thread2 = new Thread(() -> {
           System.out.println("thread2 begin");
           try {
               thread1.join();
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
           System.out.println("thread2 end");
       });
       thread2.start();

       thread2.join();

        System.out.println("main end");

    }
}
