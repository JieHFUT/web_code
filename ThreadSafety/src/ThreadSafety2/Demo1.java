package ThreadSafety2;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JIE
 * Date: 2022-09-06
 * Time: 21:44
 */
public class Demo1 {

    //编译器的优化
    public static void main(String[] args) {

        Demo2 demo2 = new Demo2();

        Thread thread1 = new Thread(() -> {
            while (demo2.flg == 0){
                /*try {
                    Thread.sleep(100);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }*/
            }

            System.out.println("thread1执行结束");
        });
        thread1.start();


        Thread thread2 = new Thread(() ->{
            Scanner scanner = new Scanner(System.in);
            System.out.println("请输入一个整数：");
            demo2.flg = scanner.nextInt();
        });
        thread2.start();





    }
}


