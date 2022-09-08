package ThreadSafety2;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JIE
 * Date: 2022-09-08
 * Time: 14:04
 */
public class Singleton {


    //只能实例化一个对象的类
    private static Singleton instance = new Singleton();


    public static Singleton getInstance(){
        return instance;
    }

    private Singleton(){

    }

}
