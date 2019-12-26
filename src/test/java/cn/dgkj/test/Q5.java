package cn.dgkj.test;

import org.junit.Test;

import java.util.Scanner;

/**
 * @author mawt
 * @description
 * @date 2019/11/21
 */
public class Q5 {

    public static void main(String[] args) {
        System.out.println(123);
        Scanner scanner = new Scanner(System.in);
        String word1 = scanner.nextLine();
        String word2 = scanner.nextLine();
        scanner.close();
        int len = 0;
        if (word1 == null || word2 == null || (len = word1.length()) != word2.length()) {
            System.out.println(0);
        }
        int num = 0;
        char c1, c2;
        for (int i = 0; i < len; i++) {
            c1 = word1.charAt(i);
            c2 = word2.charAt(i);
            if (c1 != c2) {
                num ++;
            }
        }
        System.out.println(num);

    }

    @Test
    public void xx() {

    }



    public static class MyClass {
        long var;

        public void MyClass(long param) {
            var = param;
        }

        public static void main(String[] args) {
            MyClass a, b;
            a = new MyClass();
        //    b = new MyClass(5);
        }
        //(   ()(()()(((()(())))))   ()()()(()()())   )   ()()()   ((((    0    ))))   ()()()(()()()()()())   )
    }


    // 13
    //  01101
    // 17
    //  10001
    // 00001

    @Test
    public void run() {
        System.out.println(-5 + 1 / 4 + 2 * -3 + 5.0);
        String cbbd = new Q5().longestPalindrome("dbcbcbd");
        System.out.println(cbbd);
    }

    public String longestPalindrome(String s) {
        int length = s.length();
        String subStr = null;
        String maxStr = null;
        int maxLen = 0;
        for (int i = 0; i < length; i++) {
            for (int j = length; j > i; j--) {
                subStr = s.substring(i, j);
                if (isPalindromic(subStr) && (j - i - 1 >= maxLen)) {
                    maxLen = subStr.length();
                    maxStr = subStr;
                }
            }
        }
        return maxStr;
    }

    /**
     * 是否是回文数
     *
     * @param subStr
     * @return
     */
    private boolean isPalindromic(String subStr) {
        int length = subStr.length();
        //[0,1,2,3]   4 >>> 2 2
        //[0,1,2]     3 >>> 2 1
        int menLen = length >>> 1;
        for (int i = 0; i < menLen; i++) {
            if (subStr.charAt(i) != subStr.charAt(length - i - 1)) {
                return false;
            }
        }
        return true;
    }

}
