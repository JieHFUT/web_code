package thread;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JIE
 * Date: 2022-08-18
 * Time: 1:52
 */
public class LearnThread4 {
    public static void main(String[] args) {
        Thread thread = new Thread(() ->{
            while(true){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "my thread name");
        thread.start();


        System.out.println(thread.getId());
        System.out.println(thread.getName());
        System.out.println(thread.getState());
        System.out.println(thread.getPriority());
        System.out.println(thread.isDaemon());
        System.out.println(thread.isAlive());
        /**
         * 12 ------ 这个jvm的内部id
         * my thread name
         * TIMED_WAITING
         * 5
         * false
         * true ------ 瞬间的状态
         */





    }
}
