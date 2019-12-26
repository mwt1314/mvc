package cn.dgkj.singleton;

/**
 * @author mawt
 * @description
 * @date 2019/11/26
 */
public class Singleton {

    private static volatile Singleton singleton;

    private Singleton() {

    }

    public static Singleton getInstance() {
        Singleton shareSingleton = Singleton.singleton;
        if (shareSingleton == null) {
            synchronized (Singleton.class) {
                shareSingleton = Singleton.singleton;
                if (shareSingleton == null) {
                    shareSingleton = new Singleton();
                    Singleton.singleton = shareSingleton;
                }
            }
        }
        return Singleton.singleton;
    }

}
