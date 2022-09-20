package ThreadSafety4;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JIE
 * Date: 2022-09-14
 * Time: 17:59
 */
public class UtilTimer {

    public static void main(String[] args) throws InterruptedException {

        Timer timer = new Timer();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("这是一个要执行的任务");
            }
        }, 3000);

        while (true){
            System.out.println("main");
            Thread.sleep(1000);
        }
    }
}
