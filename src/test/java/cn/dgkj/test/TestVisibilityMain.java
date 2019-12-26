package cn.dgkj.test;

import java.util.concurrent.TimeUnit;

public class TestVisibilityMain {
    private static boolean isRunning = true;

    // 可尝试添加volatile执行，其余不变，查看线程A是否被停止
    //private static volatile boolean isRunning = true;

    public static void main(String[] args) throws InterruptedException {
//1,开启线程A,读取共享变量值 isRunning，默认为true 
        new Thread(() -> {
            // --> 此处用的lamda表达式，{}内相当于Thread的run方法内部需执行任务
            System.out.println(Thread.currentThread().getName() + "进入run方法");
            while (isRunning) {
                System.out.println(System.out);
                System.out.println(Thread.currentThread().getName() + "运行中");
            }
            System.out.println(Thread.currentThread().getName() + "被停止！");
        }, "A").start();
        //2，主线程休眠1s, 确保线程A先被调度执行
        TimeUnit.SECONDS.sleep(1);
        //3,主线程修改共享变量值 为flase,验证线程A是否能够获取到最新值，跳出while循环  --> 验证可见性
        isRunning = false;
        System.out.println(Thread.currentThread().getName() + "修改isRunning为: " + isRunning);
    }
}