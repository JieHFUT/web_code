package ThreadSafety1;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JIE
 * Date: 2022-08-20
 * Time: 16:09
 */
public class Safety3 {

    // public volatile static int flg;
    // 相当于 volatile 操作显示的禁止了编译器的优化过程

    public static void main(String[] args) {
        Thread thread1 = new Thread(() ->{
           while (TestSafety3.flg == 0){
               //System.out.println("thread1 线程1正在执行！");
               /*try {
                   Thread.sleep(100);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }*/
           }
            System.out.println("thread1 finish");
        });
        thread1.start();


        Thread thread2 = new Thread(() ->{
            Scanner scanner = new Scanner(System.in);
            System.out.println("请输入一个整数：");
            int num = scanner.nextInt();
            TestSafety3.flg = num;
        });
        thread2.start();
    }
}
