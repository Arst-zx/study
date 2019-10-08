package test;

import algorithm.java.Solution3;
import org.junit.Test;

/**
 * @author: 章鑫
 * @Email: zhangx511@chinaunicom.cn
 * @Project_name：study
 * @Name: Solution3
 * @date: 2019-09-03 15:45
 * @Description: 无重复字符的最长子串
 **/

public class Solution3Test {

    @Test
    public void lengthOfLongestSubstring() {
        Solution3 solution3 = new Solution3();
        int m = solution3.lengthOfLongestSubstring("");
        System.out.println(m);
    }
}