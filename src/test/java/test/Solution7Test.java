package test;

import org.junit.Test;

/**
 * @author zhangx511
 */

public class Solution7Test {

    @Test
    public void myAtoi() {

        Solution7 solution7 = new Solution7();
        int m = solution7.myAtoi("  -42");
        System.out.println(m);
    }

}