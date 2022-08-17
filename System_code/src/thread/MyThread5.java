package thread;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JIE
 * Date: 2022-08-17
 * Time: 23:30
 */
public class MyThread5 {
    public static void main(String[] args) {
        Thread thread = new Thread(() ->{
            while(true){
                System.out.println("hello thread");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
    }
}
