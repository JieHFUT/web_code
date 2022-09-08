package ThreadSafety1;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JIE
 * Date: 2022-08-20
 * Time: 0:27
 */
public class TestSafety1 {
    public int number = 0;
    public static int num = 0;

    public synchronized void addition(){   //这个synchronized 意味着对this加锁
        this.number++;                      //这个加锁不会对调用其他的方法加锁
    }

    public void additionNor(){
         this.number++;
    }

    public synchronized static void func1(){
         // 这个synchronized 是指对类对象进行加锁
         // 不会对其他的类方法加锁
    }

    public static void func3(){
         num++;
    }

    public synchronized static void func4(){
         num++;
    }

    public synchronized static void func5(){
         num++;
    }
    //调用func4和func5则会参数锁竞争 ----- 10_0000

    public static void func2(){
         synchronized (TestSafety1.class){
             // 这个和上面的对类对象加锁的行为是一样的，也是直接对类对象进行加锁
         }
    }
    //修饰代码块 this 指的是锁的对象，指的是针对哪个对象进行加锁
    public void sub(){
         synchronized (this){  //这个this ---- 专指testSafety这个对象
             this.number--;
         }
         this.number++;
    }





}
