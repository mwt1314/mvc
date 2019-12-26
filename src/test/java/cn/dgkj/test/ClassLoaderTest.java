package cn.dgkj.test;/**
 * @Auther: mawt
 * @Date: 2019/11/18 09:11
 * @Description:
 */

import org.junit.Test;

/**
 * @author mawt
 * @description classloader
 * @date 2019/11/18
 */
public class ClassLoaderTest {

    @Test
    public void test() {
        System.out.println(Son.strFather);
    }

}

class YeYe{
    static {
        System.out.println("YeYe静态代码块");
    }
}

class Father extends YeYe{
    public final static String strFather="HelloJVM_Father";

    static{
        System.out.println("Father静态代码块");
    }
}

class Son extends Father{
    public static String strSon="HelloJVM_Son";

    static{
        System.out.println("Son静态代码块");
    }
}

