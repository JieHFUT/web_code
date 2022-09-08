package ThreadSafety2;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JIE
 * Date: 2022-09-08
 * Time: 14:04
 */
public class Singleton {

    private static Singleton instance = new Singleton();


    public static Singleton getInstance(){
        return instance;
    }

    private Singleton(){

    }

}
