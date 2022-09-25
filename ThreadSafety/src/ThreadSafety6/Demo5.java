package ThreadSafety6;

import java.util.concurrent.Semaphore;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JIE
 * Date: 2022-09-23
 * Time: 19:47
 */
public class Demo5 {

    public static void main(String[] args) throws InterruptedException {

        Semaphore semaphore = new Semaphore(3);




        semaphore.acquire();
        System.out.println("acquire resource");
        semaphore.acquire();
        System.out.println("acquire resource");
        semaphore.acquire();
        System.out.println("acquire resource");

        semaphore.release();
        System.out.println("release resource");


        semaphore.acquire();
        System.out.println("acquire resource");

        semaphore.release();
        System.out.println("release resource");


    }


}
