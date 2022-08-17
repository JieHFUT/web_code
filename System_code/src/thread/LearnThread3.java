package thread;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JIE
 * Date: 2022-08-18
 * Time: 1:21
 */
public class LearnThread3 {
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    System.out.println("hello thread");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "线程名");
        thread.start();

        System.out.println(thread.getId());
        System.out.println(thread.getName());
        System.out.println(thread.getState());
        System.out.println(thread.getPriority());


        while(true){
            System.out.println("hello main");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
