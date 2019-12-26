package cn.dgkj.singleton;

/**
 * @author mawt
 * @description
 * @date 2019/11/19
 */
public class Singleton1 {

    private static Singleton1 singleton1;

    private Singleton1() {

    }

    public static Singleton1 getInstance() {
        if (singleton1 == null) {
            singleton1 = new Singleton1();
        }
        return singleton1;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 300; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    Singleton1 instance = Singleton1.getInstance();
                    System.out.println(instance);
                }
            }).start();
        }
    }

}
