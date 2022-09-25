package ThreadSafety6;

import java.util.concurrent.CountDownLatch;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JIE
 * Date: 2022-09-23
 * Time: 19:50
 */
public class Demo6 {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(10);

        // 模拟跑步比赛
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(()->{
                try {
                    Thread.sleep(3000);

                    System.out.println("arrive terminal");
                    // countDown 相当于 "撞线"
                    latch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            thread.start();
        }


        latch.await();
        System.out.println("compitition is over");
    }


}
