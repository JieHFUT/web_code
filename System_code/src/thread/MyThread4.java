package thread;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JIE
 * Date: 2022-08-17
 * Time: 23:26
 */
public class MyThread4 {
    public static void main(String[] args) {
        /*Runnable runnable = new Runnable() {
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
        };
        Thread thread = new Thread(runnable);
        thread.start();*/

        Thread thread = new Thread(new Runnable() {
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
        });
        thread.start();
    }


}

