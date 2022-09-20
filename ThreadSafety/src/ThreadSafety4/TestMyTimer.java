package ThreadSafety4;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JIE
 * Date: 2022-09-14
 * Time: 18:14
 */
public class TestMyTimer {
    public static void main(String[] args) throws InterruptedException {

        MyTimer myTimer = new MyTimer();
        myTimer.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("111111");
            }
        }, 3000);


        myTimer.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("222222");
            }
        }, 1000);


        myTimer.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("333333");
            }
        }, 5000);


        while (true){
            System.out.println("mian");
            Thread.sleep(500);
        }

    }
}
