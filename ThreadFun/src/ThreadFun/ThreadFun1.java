package ThreadFun;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JIE
 * Date: 2022-08-18
 * Time: 17:39
 */
public class ThreadFun1 {


    // Thread state


    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
//           while (true){
               System.out.println("hello thread");
               try {
                   Thread.sleep(1000);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
//           }
        });
        // start 之前进行获取还没有创建的时候的状态
        System.out.println(thread.getState());

        thread.start();

        //Thread.sleep(500);
        System.out.println(thread.getState());
        thread.join();
        //获取线程执行完毕后的状态
        System.out.println(thread.getState());


    }

}




















