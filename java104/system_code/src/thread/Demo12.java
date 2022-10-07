package thread;

// 控制 main 先运行 t1, t1 执行完 再执行 t2
public class Demo12 {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("main begin");
        Thread t1 = new Thread(() -> {
            System.out.println("t1 begin");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("t1 end");
        });
        t1.start();
        // 等待 t1 结束.
        t1.join();

        Thread t2 = new Thread(() -> {
            System.out.println("t2 begin");
            try {
                Thread.sleep(1000);
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
