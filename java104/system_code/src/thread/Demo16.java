package thread;


import java.util.Scanner;

public class Demo16 {
    // 写一个内部类, 此时这个内部类就处在 Demo16 的内部, 和刚才那个 Counter 不是一个作用域了~~
    static class Counter {
        public int flag = 0;
    }

    public static void main(String[] args) {
        Counter counter = new Counter();

        Thread t1 = new Thread(() -> {
            while (counter.flag == 0) {
                // 执行循环, 但是此处循环啥都不做~~
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("t1 结束");
        });
        t1.start();

        Thread t2 = new Thread(() -> {
            // 让用户输入一个数字, 赋值给 flag
            Scanner scanner = new Scanner(System.in);
            System.out.println("请输入一个整数: ");
            counter.flag = scanner.nextInt();
        });
        t2.start();
    }
}
