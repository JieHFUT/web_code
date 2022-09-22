package ThreadSafety5;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JIE
 * Date: 2022-09-20
 * Time: 16:48
 */
public class TestMyThreadPool {

    public static void main(String[] args) throws InterruptedException {
        MyThreadPool pool = new MyThreadPool(10);

        for (int i = 0; i < 100; i++) {
            pool.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println("this is a mission");
                }
            });
        }


        while (true){
            System.out.println("main");
            Thread.sleep(500);
        }


    }
}
