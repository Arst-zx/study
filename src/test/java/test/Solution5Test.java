package test;

import algorithm.java.Solution5;
import org.junit.Test;

/**
 * @author: 章鑫
 * @Email: zhangx511@chinaunicom.cn
 * @Project_name：study
 * @Name: Solution5
 * @date: 2019-09-05 17:16
 * @Description: 最长回文子串
 *
 **/

public class Solution5Test {

    @Test
    public void longestPalindrome() {
        Solution5 solution5 = new Solution5();
        String string = solution5.longestPalindrome(" "); // babad,ccc,cbbd
        System.out.println(string);
    }
}