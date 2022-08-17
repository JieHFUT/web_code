package thread;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JIE
 * Date: 2022-08-17
 * Time: 23:17
 */
public class MyThread3 {
    public static void main(String[] args) {
        Thread thread = new Thread(){
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
        };
        thread.start();//在这里这个匿名内部类的线程才被创建了出来
    }
}
