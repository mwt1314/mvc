package cn.dgkj.test;


import org.springframework.context.annotation.Configuration;

@Configuration
public class TestIOCBean2 {

    public void fun(String str) {
        System.out.println(str);
    }

    public void printName() {
        System.out.println("类名 ：" + Thread.currentThread().getStackTrace()[1].getClassName());
    }

}
