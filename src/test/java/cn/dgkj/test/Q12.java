package cn.dgkj.test;

import org.junit.Test;

import java.util.*;

/**
 * @author mawt
 * @description
 * @date 2019/11/21
 */
public class Q12 {

    @Test
    public void run() {
        System.out.println(intToRoman(400));
    }

    //I             1
    //V             5
    //X             10
    //L             50
    //C             100
    //D             500
    //M             1000
    public String intToRoman(int num) {
        StringBuilder roman = new StringBuilder();
        if (num >= 1000) {
            int max = num / 1000;  //求商
            for (int i = 0; i < max; i++) {
                roman.append("M");
            }
            num = num % 1000; //求余
        }
        if (num >= 500) {
            //[500, 999]
            // 900 1000 - 100
            // 800
            if (num >= 900) {
                roman.append("CM");
                num = num - 900;
            } else {
                roman.append("D");
                num = num - 500;
            }
        }
        if (num >= 100) {
            //[100, 499]
            if (num >= 400) {
                roman.append("CD");
                num = num - 400;
            } else {
                int max = num / 100; //求商
                for (int i = 0; i < max; i++) {
                    roman.append("C");
                }
                num = num % 100; //求余
            }
        }
        if (num >= 50) {
            //[50, 99]
            if (num >= 90) {
                roman.append("XC");
                num = num - 90;
            } else {
                roman.append("L");
                num = num - 50;
            }
        }
        if (num >= 10) {
            //[0, 49]
            if (num >= 40) {
                roman.append("XL");
                num = num - 40;
            } else {
                int max = num / 10; //求商
                for (int i = 0; i < max; i++) {
                    roman.append("X");
                }
                num = num % 10; //求余
            }
        }
        if (num >= 5) {
            //[5, 9]
            if (num >= 9) {
                roman.append("IX");
                num = num - 9;
            } else {
                roman.append("V");
                num = num - 5;
            }
        }
        if (num > 0) {
            //[0, 4]
            if (num == 4) {
                roman.append("IV");
            }else {
                for (int i = 0; i < num; i++) {
                    roman.append("I");
                }
            }
        }
        return roman.toString();
    }


    @Test
    public void xx() {
        String[] args = {"abce", "abc", "abcd", ""};
        System.out.println(longestCommonPrefix(args));
    }

    public String longestCommonPrefix(String[] strs) {
        int minLen = 0;
        for (String str : strs) {
            if (minLen == 0) {
                minLen = str.length();
            } else {
                minLen = Math.min(minLen, str.length());
            }
        }
        if (minLen == 0) return "";
        String commonPrefix = "";
        boolean exist;
        for (int i = minLen; i > 0; i--) {
            exist = true;
            for (String str : strs) {
                if (!"".equals(commonPrefix)) {
                    if (!commonPrefix.equals(str.substring(0, i))) {
                        exist = false;
                        break;
                    }
                } else {
                    commonPrefix= str.substring(0, i);
                }
            }
            if (exist) {
                break;
            } else {
                commonPrefix = "";
            }
        }
        return commonPrefix;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        //去重
        Set<Integer> set = new LinkedHashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        List<List<Integer>> list = new ArrayList<>();
        /*int length = set.size();
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                for (int k = j + 1; k < length; k++) {
                    if (set.+ set.get(j) + set.get(k) == 0) {
                        List<Integer> l = new ArrayList<>();
                        l.add(set.get(i));
                        l.add(set.get(j));
                        l.add(set.get(k));
                        list.add(l);
                    }
                }
            }
        }*/
        return list;
    }
}
