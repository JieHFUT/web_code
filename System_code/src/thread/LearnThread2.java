package thread;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JIE
 * Date: 2022-08-17
 * Time: 22:49
 */
class MyRunnable implements Runnable{

    @Override
    public void run() {
        while(true){
            System.out.println("hello thread");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class LearnThread2 {

    public static void main(String[] args) {
        //创建线程
        Runnable runnable = new MyRunnable();
        Thread thread = new Thread(runnable);
        thread.start();


        while(true){
            System.out.println("hello main");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}