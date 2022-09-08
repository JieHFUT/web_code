package ThreadSafety2;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JIE
 * Date: 2022-09-07
 * Time: 21:44
 */
public class Demo4 {

    public static void main(String[] args) {

        Object locker1 = new Object();
        Object locker2 = new Object();

        Thread thread1 = new Thread(() ->{
            synchronized (locker1){
                try {
                    System.out.println("wait start");
                    locker1.wait();
                    System.out.println("wait end");
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        });
        thread1.start();


        Thread thread2 = new Thread(() ->{
            synchronized (locker1){
                System.out.println("notify start");
                System.out.println("请输入任意一个数字启动 notify: ");
                Scanner scanner = new Scanner(System.in);
                scanner.next();
                locker1.notify();
                System.out.println("notify end");
            }
        });
        thread2.start();




    }

}




