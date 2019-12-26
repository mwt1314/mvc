package cn.dgkj.other;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author mawt
 * @description
 * @date 2019/11/29
 */
public class Dog {

    //测试主方法
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("输入想要查询生肖的年份：");
        int year = input.nextInt();
        TDyear(year);
        TDyearArray(year);
        TDyearArrayList(year);
    }

    //方法一：用简单清晰明了的switch语句实现
    public static void TDyear(int year) {
        int T = (year - 3) % 10;
        int D = (year - 3) % 12;

        switch (T) {
            case 1:
                System.out.print("甲");
                break;
            case 2:
                System.out.print("乙");
                break;
            case 3:
                System.out.print("丙");
                break;
            case 4:
                System.out.print("丁");
                break;
            case 5:
                System.out.print("戊");
                break;
            case 6:
                System.out.print("己");
                break;
            case 7:
                System.out.print("庚");
                break;
            case 8:
                System.out.print("辛");
                break;
            case 9:
                System.out.print("壬");
                break;
            case 0:
                System.out.print("癸");
                break;
        }

        switch (D) {
            case 1:
                System.out.println("子鼠年");
                break;
            case 2:
                System.out.println("丑牛年");
                break;
            case 3:
                System.out.println("寅虎年");
                break;
            case 4:
                System.out.println("卯兔年");
                break;
            case 5:
                System.out.println("辰龙年");
                break;
            case 6:
                System.out.println("巳蛇年");
                break;
            case 7:
                System.out.println("午马年");
                break;
            case 8:
                System.out.println("未羊年");
                break;
            case 9:
                System.out.println("申猴年");
                break;
            case 10:
                System.out.println("酉鸡年");
                break;
            case 11:
                System.out.println("戌狗年");
                break;
            case 0:
                System.out.println("亥猪年");
                break;
        }

    }

    //方法二：用字符串数组进行改进
    public static void TDyearArray(int year) {
        int T = (year - 3) % 10;
        int D = (year - 3) % 12;

        String[] TT = {"癸", "甲", "乙", "丙", "丁", "戊", "己", "庚", "辛", "壬"};
        String[] DD = {"亥猪年", "子鼠年", "丑牛年", "寅虎年", "卯兔年", "辰龙年", "巳蛇年", "午马年", "未羊年", "申猴年", "酉鸡年", "戌狗年"};
        System.out.println(TT[T] + DD[D]);
    }

    //方法三：用ArrayList集合进行修改
    public static void TDyearArrayList(int year) {

        int T = (year - 3) % 10;
        int D = (year - 3) % 12;

        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();

        list1.add("癸");
        list1.add("甲");
        list1.add("乙");
        list1.add("丙");
        list1.add("丁");
        list1.add("戊");
        list1.add("己");
        list1.add("庚");
        list1.add("辛");
        list1.add("壬");

        list2.add("亥猪年");
        list2.add("子鼠年");
        list2.add("丑牛年");
        list2.add("寅虎年");
        list2.add("卯兔年");
        list2.add("辰龙年");
        list2.add("巳蛇年");
        list2.add("午马年");
        list2.add("未羊年");
        list2.add("申猴年");
        list2.add("酉鸡年");
        list2.add("戌狗年");
        System.out.println(list1.get(T) + list2.get(D));
    }
}
