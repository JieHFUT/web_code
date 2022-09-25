package ThreadSafety6;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JIE
 * Date: 2022-09-23
 * Time: 19:35
 */
public class Demo3 {
    public static void main(String[] args) {
        ReentrantLock locker = new ReentrantLock(true);
        try {
            locker.tryLock();
        }finally {
            locker.unlock();
        }
    }
}
