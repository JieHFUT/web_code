package thread;


public class Demo26 {

    private static void func() {
        // .......进行一些多线程操作
        // 第一次加锁
        synchronized (Demo26.class) {
            // 第二次加锁
            synchronized (Demo26.class) {

            }
        }
    }


    public static void main(String[] args) {
        func();
    }
}












