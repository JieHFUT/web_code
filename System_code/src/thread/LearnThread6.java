package thread;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JIE
 * Date: 2022-08-18
 * Time: 7:52
 */
public class LearnThread6 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() ->{
            while (!Thread.currentThread().isInterrupted()){
                System.out.println("线程运行中...");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    // e.printStackTrace();

                    // [1] 立即退出
                    // break;


                    // [2] 稍后退出
                    try {
                        Thread.sleep(10000);
                    }catch (InterruptedException exception){
                        exception.printStackTrace();
                    }
                    break;
                }
            }
        });
        thread.start();
        Thread.sleep(5000);
        System.out.println("控制新线程退出！");
        thread.interrupt();//InterruptedException

    }
}
