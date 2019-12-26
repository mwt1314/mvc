package cn.dgkj.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.concurrent.TimeUnit;

/**
 * @author mawt
 * @description
 * @date 2019/11/18
 */
public class VolatileTest {

    public boolean isRunning = true;

    public static void main(String[] args) throws InterruptedException {
        new VolatileTest().run();
    }

    @Test
    public void run() throws InterruptedException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "进入run方法");
                while (isRunning) {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "运行中");
                }
                System.out.println(Thread.currentThread().getName() + "退出");
            }
        }).start();

        TimeUnit.SECONDS.sleep(5);
        isRunning = false;
        System.out.println(Thread.currentThread().getName() + "修改isRunning为: " + isRunning);
    }

}
