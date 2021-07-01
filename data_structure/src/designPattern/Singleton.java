package designPattern;

/**
 * 单例模式双重校验锁
 */
public class Singleton {

    private static Singleton instance;

    private Singleton(){}

    public static  Singleton getInstance(){
        if(instance == null){
            synchronized (Singleton.class){
                if(instance == null){
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}

/**
 * 单例模式，饿汉式，立马实例化
 */
class Singleton2{
    private static  Singleton2 instance = new Singleton2();

    private Singleton2(){}

    public static Singleton2 getInstance(){
        return instance;
    }
}


/**
 * 单例模式，懒汉式，有线程不安全的风险
 */
class Singleton3{

    private static Singleton3 instance;

    private Singleton3(){}

    public static Singleton3 getInstance(){
        if(instance == null){
            instance = new Singleton3();
        }
        return instance;
    }

}
