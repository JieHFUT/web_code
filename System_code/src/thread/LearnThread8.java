package thread;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JIE
 * Date: 2022-08-18
 * Time: 16:16
 */



public class LearnThread8 {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("main begin");

        Thread thread1 = new Thread(() -> {
            System.out.println("thread1 begin");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("thread1 end");
        });
        thread1.start();
        thread1.join();
        // 考虑在执行thread1.join()；之前就执行了thread2.start(); 和没有执行thread2.start();

        Thread thread2 = new Thread(() -> {
            System.out.println("thread2 begin");
            try {
                Thread.sleep(2000);
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
