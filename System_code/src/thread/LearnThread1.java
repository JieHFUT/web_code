package thread;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JIE
 * Date: 2022-08-17
 * Time: 16:35
 */

class MyThread extends Thread{
    //描述我们创建好的线程是为了执行什么目的
    @Override
    public void run() {
        while(true){
            System.out.println("hello, thread");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}



public class LearnThread1{

    public static void main(String[] args) {
        /**
         * 自己创建一个线程
         * java 中创建线程，离不开一个关键的类，Thread
         * 一种比较朴素的创建线程的方式，是写一个子类，继承Thread，重写其中的 run 方法
         */


        //创建线程的实例
        Thread thread = new MyThread();
        thread.start();
        //thread.run();
        /**
         * 可以看到，直接调用run，并没有创建新的线程，而只是在之前的线程中，执行了run里面的内容
         * 调用 start 则是创建了新的线程，新的线程里面会调用run， 新线程和旧线程之间是并发执行的关系
         */


        while(true){
            System.out.println("Hello, Main");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
