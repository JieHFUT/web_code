package ThreadSafety3;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JIE
 * Date: 2022-09-20
 * Time: 9:39
 */
public class TestMyBlockingQueue {
    public static void main(String[] args) {
        MyBlockingQueue queue = new MyBlockingQueue();

        Thread customer = new Thread(()->{
            while (true){
                int value = 0;
                try {
                    value = queue.take();
                    System.out.println("customer: " + value);
                    Thread.sleep(500);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        customer.start();


        Thread producer = new Thread(()->{
           int value = 0;
           while (true){
               try {
                   queue.put(value);
                   System.out.println("producer: " + value);
                   value++;
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           }
        });
        producer.start();
    }
}
