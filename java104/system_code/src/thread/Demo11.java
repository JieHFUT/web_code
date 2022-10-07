package thread;

// 这个代码演示 main 等待 t2 , t2 等待 t1
public class Demo11 {
    private static Thread t1 = null;
    private static Thread t2 = null;

    public static void main(String[] args) throws InterruptedException {
        System.out.println("main begin");
        t1 = new Thread(() -> {
            System.out.println("t1 begin");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("t1 end");
        });
        t1.start();

        t2 = new Thread(() -> {
            System.out.println("t2 begin");
            try {
                t1.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("t2 end");
        });
        t2.start();

        t2.join();
        System.out.println("main end");
    }
}
