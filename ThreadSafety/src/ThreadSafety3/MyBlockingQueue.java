package ThreadSafety3;


/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JIE
 * Date: 2022-09-20
 * Time: 9:39
 */
// 实现自己的阻塞队列
// 基于数组的方式来实现队列.
// 提供两个核心方法:
// 1. put 入队列
// 2. take 出队列
public class MyBlockingQueue {
    private int[] items = new int[100];

    private int head = 0;
    private int tail = 0;

    volatile private int size = 0;


    //入队列
    public void put(int value) throws InterruptedException {
        synchronized (this){
            while (size == items.length){
                //队列已满，无法进行插入
                this.wait();
            }
            items[tail] = value;
            tail++;

            if (tail == items.length){
                tail = 0;
            }

            size++;
            this.notify();
        }
    }


    //出队列
    public Integer take() throws InterruptedException {
        int ret = 0;
        synchronized (this){
            while (size == 0){
                //队列为空，阻塞等待
                this.wait();
            }
            ret = items[head];
            head++;

            if (head == items.length){
                head = 0;
            }
            size--;
            this.notify();
        }
        return ret;
    }

}
