package thread;

import java.util.concurrent.locks.ReentrantLock;

public class Demo29 {
    public static void main(String[] args) {
        ReentrantLock locker = new ReentrantLock(true);
        try {
            // 加锁
            // locker.lock();
            locker.tryLock();

            // 代码逻辑.... 如果中间抛出异常了, 就可能执行不到 unlock
        } finally {
            // 解锁
            locker.unlock();
        }

    }
}
