package test;

import algorithm.java.Solution1;
import org.junit.Test;

/**
 * @author: 章鑫
 * @Email: zhangx511@chinaunicom.cn
 * @Project_name：study
 * @Name: Solution1
 * @date: 2019-09-02 16:59
 * @Description: 两数之和
 **/

public class Solution1Test {

    @Test
    public void twoSum() {
        Solution1 solution = new Solution1();
        int[] input = {1,1,2,3,4,5,6,7,8,8,9,10};
        solution.twoSum(input,9);
    }
}