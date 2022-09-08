package ThreadSafety2;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JIE
 * Date: 2022-09-08
 * Time: 14:04
 */
public class SingletonLazy {

    volatile private static SingletonLazy instance = null;


    public static SingletonLazy getInstance(){
        if (instance == null){
            synchronized (SingletonLazy.class){
                if (instance == null){
                    instance = new SingletonLazy();
                }
            }
        }
        return instance;
    }

    private SingletonLazy(){};


}
