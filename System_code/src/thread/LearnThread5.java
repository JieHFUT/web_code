package thread;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JIE
 * Date: 2022-08-18
 * Time: 7:42
 */
public class LearnThread5 {

    // 用一个布尔变量表示线程是否要结束
    // 这个变量是一个成员变脸
    private static boolean isQuit = false;

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() ->{
            while (!isQuit){
                System.out.println("线程运行中.....");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("新线程执行结束");
        });
        thread.start();
        Thread.sleep(5000);
        System.out.println("控制新线程退出！");
        isQuit = true;
    }
}
