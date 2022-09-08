package ThreadSafety2;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JIE
 * Date: 2022-09-07
 * Time: 21:23
 */
public class Demo3 {

    /**
     * 1、wait --- 释放锁  等待通知  通知到达后，尝试重新获取锁
     *
     */
    public static void main(String[] args) throws InterruptedException {
        Object object = new Object();

        synchronized (object){
            System.out.println("wait 之前");
            object.wait();
            System.out.println("wait 之后");
        }



    }
}
