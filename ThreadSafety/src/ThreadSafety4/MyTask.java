package ThreadSafety4;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JIE
 * Date: 2022-09-14
 * Time: 18:15
 */
public class MyTask implements Comparable<MyTask>{
    // 通过这个类来描述一个任务

    private Runnable command;

    private long time;

    public MyTask(Runnable command, long after){
        this.command = command;

        //执行的绝对时间
        this.time = System.currentTimeMillis() + after;
    }


    public void run(){
        command.run();
    }

    public long getTime() {
        return time;
    }


    @Override
    public int compareTo(MyTask o){
        return (int) (this.time - o.time);
    }




}
