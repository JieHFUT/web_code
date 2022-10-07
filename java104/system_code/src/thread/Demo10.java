package thread;

public class Demo10 {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println("线程运行中....");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    // e.printStackTrace();

                    // [1] 立即退出
                    // break;

                    System.out.println("新线程即将退出!");
                    // [2] 稍后退出, 此处的 sleep 可以换成任意的用来收尾工作的代码
//                    try {
//                        Thread.sleep(3000);
//                    } catch (InterruptedException ex) {
//                        ex.printStackTrace();
//                    }
//                    break;

                    // [3] 不退出! 啥都不做, 就相当于忽略了异常.
                }
            }
            System.out.println("新线程已经退出!");
        });
        t.start();
        Thread.sleep(5000);
        System.out.println("控制新线程退出!");
        t.interrupt();
    }
}
