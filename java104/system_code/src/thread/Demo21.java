package thread;

// 自己模拟实现一个阻塞队列.
// 基于数组的方式来实现队列.
// 提供两个核心方法:
// 1. put 入队列
// 2. take 出队列
class MyBlockingQueue {
    // 假定最大是 1000 个元素. 当然也可以设定成可配置的.
    private int[] items = new int[1000];
    // 队首的位置
    private int head = 0;
    // 队尾的位置
    private int tail = 0;
    // 队列的元素个数
    volatile private int size = 0;

    // 入队列
    public void put(int value) throws InterruptedException {
        synchronized (this) {
            while (size == items.length) {
                // 队列已满, 无法插入
                this.wait();
            }
            items[tail] = value;
            tail++;
            // 汤老湿个人还是更建议写这个版本.
            if (tail == items.length) {
                // 注意 如果 tail 达到数组末尾, 就需要从头开始~
                tail = 0;
            }
            // 下面这个写法绝对不是错!! 也是正确的写法. 大家去掌握当然也没毛病
            // tail = tail % items.length;
            size++;
            // 即使没人在等待, 多调用几次 notify 也没啥副作用~~
            this.notify();
        }
    }

    // 出队列
    public Integer take() throws InterruptedException {
        int ret = 0;
        synchronized (this) {
            while (size == 0) {
                // 队列为空, 就等待
                this.wait();
            }
            ret = items[head];
            head++;
            if (head == items.length) {
                head = 0;
            }
            size--;
            this.notify();
        }
        return ret;
    }
}

public class Demo21 {
    public static void main(String[] args) throws InterruptedException {
        MyBlockingQueue queue = new MyBlockingQueue();
        Thread customer = new Thread(() -> {
            while (true) {
                int value = 0;
                try {
                    value = queue.take();
                    System.out.println("消费: " + value);

                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        customer.start();

        Thread producer = new Thread(() -> {
            int value = 0;
            while (true) {
                try {
                    queue.put(value);
                    System.out.println("生产: " + value);
                    value++;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        producer.start();
    }
}
