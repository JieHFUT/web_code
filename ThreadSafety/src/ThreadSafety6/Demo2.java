package ThreadSafety6;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JIE
 * Date: 2022-09-23
 * Time: 16:22
 */
public class Demo2 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        Callable<Integer> callable = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                int sum = 0;
                for (int i = 0; i <= 100; i++) {
                    sum += i;
                }
                return sum;
            }
        };


        FutureTask<Integer> task = new FutureTask<>(callable);

        Thread thread = new Thread(task);
        thread.start();

        System.out.println(task.get());


    }

}
