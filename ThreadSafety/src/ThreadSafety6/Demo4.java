package ThreadSafety6;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JIE
 * Date: 2022-09-23
 * Time: 19:37
 */
public class Demo4 {
    private static Object locker1 = new Object();

    private static Object locker2 = new Object();

    private static  Object locker3 = new Object();

    public static void main(String[] args) throws InterruptedException {

        Thread thread1 = new Thread(()->{
           try {
               for (int i = 0; i < 10; i++) {
                   synchronized (locker1){
                       locker1.wait();
                   }
                   System.out.print("A");
                   synchronized (locker2){
                       locker2.notify();
                   }
               }
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
        });

        Thread thread2 = new Thread(()->{
           try {
               for (int i = 0; i < 10; i++) {
                   synchronized (locker2){
                       locker2.wait();
                   }
                   System.out.print("B");
                   synchronized (locker3){
                       locker3.notify();
                   }
               }
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
        });


        Thread thread3 = new Thread(()->{
           try {
               for (int i = 0; i < 10; i++) {
                   synchronized (locker3){
                       locker3.wait();
                   }
                   System.out.println("C");
                   synchronized (locker1){
                       locker1.notify();
                   }
               }
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
        });



        thread1.start();
        thread2.start();
        thread3.start();

        Thread.sleep(1000);
        synchronized (locker1){
            locker1.notify();
        }




    }

}
