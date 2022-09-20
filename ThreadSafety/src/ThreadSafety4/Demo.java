package ThreadSafety4;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JIE
 * Date: 2022-09-20
 * Time: 10:27
 */
public class Demo {
    //计时器
    public static void main(String[] args) throws InterruptedException {

        Timer timer = new Timer();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("this is the first mission");
            }
        }, 3000);

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("this is second mission");
            }
        }, 1500);



        while (true){
            System.out.println("main");
            Thread.sleep(1000);
        }


    }
}
