package thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Demo28 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<Integer> callable = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                int sum = 0;
                for (int i = 1; i <= 1000; i++) {
                    sum += i;
                }
                return sum;
            }
        };
        // 套上一层, 目的是为了获取到后续的结果.
        FutureTask<Integer> task = new FutureTask<>(callable);
        Thread t = new Thread(task);
        t.start();

        // 在线程 t 执行结束之前, get 会阻塞. 直到说 t 执行完了, 结果算好了,
        // get 才能返回. 返回值就是 call 方法 return 的内容.
        System.out.println(task.get());
    }
}
