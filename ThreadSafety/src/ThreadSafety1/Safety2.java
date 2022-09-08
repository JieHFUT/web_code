package ThreadSafety1;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JIE
 * Date: 2022-08-20
 * Time: 15:31
 */
public class Safety2 {

    public static Object locker1 = new Object();
    public static Object locker2 = new Object();

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            synchronized (locker1){
                System.out.println("locker1 start");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("locker1 finish");
            }
        });
        thread1.start();


        Thread thread2 = new Thread(() -> {
            synchronized (locker2){
                System.out.println("locker2 start");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("locker2 finish");
            }
        });
        thread2.start();


    }
}
